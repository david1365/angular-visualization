import {NgModule} from '@angular/core';

import {LoginRoutingModule} from './login-routing.module';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {CommonModule} from "@angular/common";
import {LoginComponent} from "./login.component";
import {CardModule} from "primeng/card";
import {InputTextModule} from "primeng/inputtext";
import {DividerModule} from "primeng/divider";
import {ButtonModule} from "primeng/button";


/**
 * @author Davood Akbari - 1399
 * daak1365@gmail.com
 * daak1365@yahoo.com
 * 09125188694
 */

@NgModule({
    imports: [
        LoginRoutingModule,
        FormsModule,
        ReactiveFormsModule,
        CommonModule,

        CardModule,
        InputTextModule,
        DividerModule,
        ButtonModule
    ],
    providers: [],
    declarations: [LoginComponent],
    exports: [LoginComponent]
})
export class LoginModule {
}
