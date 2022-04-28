import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { SqlEditorComponent } from './sql-editor.component';

/**
 * @author Davood Akbari - 1399
 * daak1365@gmail.com
 * daak1365@yahoo.com
 * 09125188694
 */

const routes: Routes = [
  { path: '', component: SqlEditorComponent },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class SqlEditorRoutingModule { }
