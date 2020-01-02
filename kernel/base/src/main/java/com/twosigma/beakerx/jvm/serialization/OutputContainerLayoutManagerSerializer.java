/*
 *  Copyright 2014 TWO SIGMA OPEN SOURCE, LLC
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.twosigma.beakerx.jvm.serialization;

import com.twosigma.beakerx.util.SerializerUtil;
import com.twosigma.beakerx.jvm.object.OutputContainerLayoutManager;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public abstract class OutputContainerLayoutManagerSerializer<T extends OutputContainerLayoutManager> extends
                                                                                                     JsonSerializer<T> {

  private final BeakerObjectConverter objectSerializerProvider;

  public OutputContainerLayoutManagerSerializer(BeakerObjectConverter osp) {
    objectSerializerProvider = osp;
  }

  protected BeakerObjectConverter getObjectSerializer() {
    return objectSerializerProvider;
  }

  @Override
  public void serialize(T value,
                        JsonGenerator jgen,
                        SerializerProvider provider)
    throws IOException, JsonProcessingException {

    synchronized (value) {
      jgen.writeStartObject();
      jgen.writeObjectField("type", SerializerUtil.getTypeName(value));
      jgen.writeObjectField("borderDisplayed", value.isBorderDisplayed());
      serialize(value, jgen);
      jgen.writeEndObject();
    }
  }

  protected abstract void serialize(T value, JsonGenerator jgen) throws IOException;
}
