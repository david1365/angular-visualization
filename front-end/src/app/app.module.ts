import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {APP_BASE_HREF, registerLocaleData} from '@angular/common';
import en from '@angular/common/locales/en';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {IconsProviderModule} from './icons-provider.module';
import {API_PREFIX} from "./app.token.d";
import {HTTP_INTERCEPTORS, HttpClientModule} from "@angular/common/http";
import {SidebarModule} from 'primeng/sidebar';
import {ToolbarModule} from 'primeng/toolbar';
import {ButtonModule} from 'primeng/button';

import {PanelMenuModule} from 'primeng/panelmenu';
import {environment} from "../environments/environment";
import {AuthenticationInterceptor} from "./pages/security/Services/authentication/authentication.interceptor";
import {ErrorHandlerInterceptor} from "./pages/security/Services/authentication/ error-handler.interceptor";
import {MessageService} from "primeng/api";
import {ToastModule} from "primeng/toast";
import {ProgressBarModule} from "primeng/progressbar";
import {GatewayInterceptor} from "./pages/security/Services/authentication/gateway.interceptor";

/**
 * @author Davood Akbari - 1399
 * daak1365@gmail.com
 * daak1365@yahoo.com
 * 09125188694
 */

registerLocaleData(en);

@NgModule({
    declarations: [
        AppComponent
    ],
    imports: [
        BrowserModule,
        AppRoutingModule,
        BrowserAnimationsModule,
        IconsProviderModule,
        HttpClientModule,

        ToolbarModule,
        SidebarModule,
        ButtonModule,
        PanelMenuModule,
        ToastModule,
        ProgressBarModule
    ],
    providers: [
        MessageService,
        {provide: HTTP_INTERCEPTORS, useClass: AuthenticationInterceptor, multi: true},
        {provide: HTTP_INTERCEPTORS, useClass: GatewayInterceptor, multi: true},
        {provide: HTTP_INTERCEPTORS, useClass: ErrorHandlerInterceptor, multi: true},
        // {provide: NZ_I18N, useValue: en_US},
        {provide: API_PREFIX, useValue: environment.apiUrl},
        {provide: APP_BASE_HREF, useValue: '/front'}
    ],
    bootstrap: [AppComponent]
})
export class AppModule {
}
