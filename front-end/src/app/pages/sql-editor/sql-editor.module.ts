import {NgModule} from '@angular/core';

import {SqlEditorRoutingModule} from './sql-editor-routing.module';

import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {CommonModule} from "@angular/common";
import {ButtonModule} from 'primeng/button';
import {SqlEditorComponent} from "./sql-editor.component";
import {CodemirrorModule} from "@ctrl/ngx-codemirror";
import {ToolbarModule} from "primeng/toolbar";


/**
 * @author Davood Akbari - 1399
 * daak1365@gmail.com
 * daak1365@yahoo.com
 * 09125188694
 */

@NgModule({
    imports: [
        SqlEditorRoutingModule,
        FormsModule,
        ReactiveFormsModule,
        CommonModule,

        ButtonModule,
        CodemirrorModule,
        ToolbarModule
    ],
    providers: [
        // FormBuilder
    ],
    declarations: [SqlEditorComponent],
    exports: [SqlEditorComponent]
})
export class SqlEditorModule {
}
