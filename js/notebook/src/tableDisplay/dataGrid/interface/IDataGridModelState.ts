/*
 *  Copyright 2017 TWO SIGMA OPEN SOURCE, LLC
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

import IHihglighterState from "./IHighlighterState";

export default interface IDataModelState {
  alignmentForColumn?: {},
  alignmentForType?: {},
  cellHighlighters: IHihglighterState[],
  columnNames: string[],
  columnOrder: string[],
  columnsFrozen?: {},
  columnsFrozenRight?: {}, //feature is dropped
  columnsVisible: {},
  contextMenuItems?: string[],
  contextMenuTags?: {},
  dataFontSize?: number|null,
  doubleClickTag?: string|null,
  fontColor?: string[],
  filteredValues?: any[],
  hasDoubleClickAction?: boolean,
  hasIndex: boolean,
  headerFontSize?: number|null,
  headersVertical?: boolean,
  rendererForColumn?: {},
  rendererForType?: {},
  stringFormatForColumn: {},
  stringFormatForType?: {},
  subtype?: string,
  timeZone?: string,
  timeStrings?: any,
  tooManyRows?: boolean,
  tooltips: string[][],
  type?: string,
  types: string[],
  values: any,
}