import {NgModule} from '@angular/core';

import {DashboardRoutingModule} from './dashboard-routing.module';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {CommonModule} from "@angular/common";
import {DashboardComponent} from "./dashboard.component";

/**
 * @author Davood Akbari - 1399
 * daak1365@gmail.com
 * daak1365@yahoo.com
 * 09125188694
 */

@NgModule({
    imports: [
        DashboardRoutingModule,
        FormsModule,
        ReactiveFormsModule,
        CommonModule,
    ],
    providers: [],
    declarations: [DashboardComponent],
    exports: [DashboardComponent]
})
export class DashboardModule {
}
