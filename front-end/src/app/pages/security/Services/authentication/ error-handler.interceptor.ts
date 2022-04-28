import {Injectable} from '@angular/core';
import {HttpEvent, HttpHandler, HttpInterceptor, HttpRequest} from '@angular/common/http';
import {Observable, throwError} from 'rxjs';
import {catchError} from 'rxjs/operators';
import {AuthenticationService} from "./authentication.service";
import {MessageService} from "primeng/api";
import {ProgressBarService} from "./progress-bar.service";


/**
 * @author Davood Akbari - 1399
 * daak1365@gmail.com
 * daak1365@yahoo.com
 * 09125188694
 */

@Injectable()
export class ErrorHandlerInterceptor implements HttpInterceptor {
    constructor(
        private authenticationService: AuthenticationService,
        private messageService: MessageService,
        private progressBarService: ProgressBarService
    ) {
    }

    intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
        return next.handle(request).pipe(catchError(err => {
            if (err.status === 401) {
                // auto logout if 401 response returned from api
                this.authenticationService.logOut();
            }

            const error = err.error.message || err.statusText;

            this.progressBarService.hideBar();
            this.messageService.add({severity: 'error', summary: 'خطا', detail: error});

            return throwError(error);
        }))
    }
}
