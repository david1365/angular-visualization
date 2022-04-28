import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {QueryingService} from "./Services/query-string/querying.service";
import {Column} from "./Services/vo/column.vo";

/**
 * @author Davood Akbari - 1399
 * daak1365@gmail.com
 * daak1365@yahoo.com
 * 09125188694
 */

@Component({
  selector: 'ca-sql-editor',
  templateUrl: './sql-editor.component.html',
  styleUrls: ['./sql-editor.component.css']
})
export class SqlEditorComponent implements OnInit {
  form!: FormGroup;

  columnNames: Column[] = [];
  data: any[] = [];

  queryString2:any = "select"

  set queryString(query: any) {
    this.form.setValue({
      queryString: query
    })
  }

  get queryString(): any {
    return this.form.get('queryString');
  }

  constructor(private fb: FormBuilder, private queryingService: QueryingService) {
  }

  ngOnInit(): void {
    this.form = this.fb.group({
      queryString: [null, [Validators.required]]
    });

    this.queryString = 'SELECT * FROM SM.BIZ_TRANSACTION_LOG_FACT BLF WHERE BLF.ID in (5772146281, 5772146281, 5772146282, 5772146285, 5772146371)';
  }


  submitForm(): void {
    for (const i in this.form.controls) {
      this.form.controls[i].markAsDirty();
      this.form.controls[i].updateValueAndValidity();
    }

    this.data = [];

    let queryString: string = this.queryString.value;

    this.queryingService.query(queryString).subscribe(queryResult => {
      this.columnNames = queryResult.columnNames;

      queryResult.resultList.forEach((row, rowIndex) => {
        let newRow: any = {};

        row.forEach((column, colIndex) => {
          let field = this.columnNames[colIndex].field;
          newRow[field] = column;
        });

        this.data[rowIndex] = newRow;
      });
    });
  }

  query1() {
    this.queryString = 'select  * from sm.biz_transaction_log_fact f \n' +
      'where f.insert_sysdate >= to_date(\'13960407\',\'YYYYMMDD\',\'nls_calendar=persian\') and f.insert_sysdate < to_date(\'13960408\',\'YYYYMMDD\',\'nls_calendar=persian\') \n' +
      'and f.channel_id = 4 \n' +
      '--and f.branch_id = 10404\n' +
      'and f.username = \'5641\'\n' +
      'and f.service_id = 1661'
  }

  query2() {
    this.queryString = 'select utl_raw.cast_to_varchar2(DBMS_LOB.SUBSTR( UTL_COMPRESS.LZ_UNCOMPRESS(l.inbound), 2000, 1 ) ) inbound_msg from sm.biz_transaction_log_lob l\n' +
      'where l.insert_sysdate >= to_date(\'13960407\',\'YYYYMMDD\',\'nls_calendar=persian\') and l.insert_sysdate < to_date(\'13960426\',\'YYYYMMDD\',\'nls_calendar=persian\')\n' +
      'and l.id in (2002344018, 2003220441)';
  }
}

