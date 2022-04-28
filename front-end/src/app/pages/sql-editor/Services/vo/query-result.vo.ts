/**
 * @author Davood Akbari - 1399
 * daak1365@gmail.com
 * daak1365@yahoo.com
 * 09125188694
 */

import {Column} from "./column.vo";

export interface QueryResultVO {
  columnNames: Column[];
  resultList: any[][];
}
