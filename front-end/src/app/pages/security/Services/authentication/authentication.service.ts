import {Inject, Injectable} from '@angular/core';
import {Account} from "../vo/account.vo";
import {BehaviorSubject, Observable} from "rxjs";
import {Router} from "@angular/router";
import {HttpClient} from "@angular/common/http";
import {API_PREFIX} from "../../../../app.token.d";
import {CurrentUser} from "../vo/current-user.vo";

/**
 * @author Davood Akbari - 1399
 * daak1365@gmail.com
 * daak1365@yahoo.com
 * 09125188694
 */

@Injectable({
    providedIn: 'root'
})
export class AuthenticationService {
    private CURRENT_USER_KEY: string = 'CURRENT_USER_KEY';
    private AUTH_URL: string = `${this.apiPrefix}/auth/login`;

    private userSubject: BehaviorSubject<CurrentUser>;
    public user: Observable<CurrentUser>;

    constructor(@Inject(API_PREFIX) private apiPrefix: string, private httpClient: HttpClient, private router: Router) {

        this.userSubject = new BehaviorSubject<CurrentUser>(this.currentUser);
        this.user = this.userSubject.asObservable();

    }

    get currentUser(): CurrentUser {
        let currentUser: any = localStorage.getItem(this.CURRENT_USER_KEY);

        return JSON.parse(currentUser);
    }

    authenticate(account: Account) {
        this.httpClient.post<CurrentUser>(this.AUTH_URL, account).subscribe(currentUser => {

            localStorage.setItem(this.CURRENT_USER_KEY, JSON.stringify(currentUser));

            this.router.navigate(['/dashboard']);

            // @ts-ignore
            this.userSubject.next(currentUser);

            // console.log(localStorage.getItem(this.CURRENT_USER_KEY));
        });
    }

    logOut() {
        localStorage.removeItem(this.CURRENT_USER_KEY);
        // @ts-ignore
        this.userSubject.next(null);
        this.router.navigate(['/login']);
    }
}
