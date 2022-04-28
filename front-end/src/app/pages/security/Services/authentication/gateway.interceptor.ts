import {Injectable} from '@angular/core';
import {HttpEvent, HttpHandler, HttpInterceptor, HttpRequest, HttpResponse} from '@angular/common/http';
import {Observable} from 'rxjs';
import {ProgressBarService} from "./progress-bar.service";
import {tap} from "rxjs/operators";


/**
 * @author Davood Akbari - 1399
 * daak1365@gmail.com
 * daak1365@yahoo.com
 * 09125188694
 */

@Injectable()
export class GatewayInterceptor implements HttpInterceptor {
    constructor(private progressBarService: ProgressBarService) {
    }

    intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
        this.progressBarService.showBar();
        return next.handle(request).pipe(tap(source => {
                if (source instanceof HttpResponse) {
                    this.progressBarService.hideBar();
                }
            })
        );
    }
}
