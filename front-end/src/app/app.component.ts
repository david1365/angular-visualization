import {Component} from '@angular/core';
import {MenuItem} from "primeng/api";
import {AuthenticationService} from "./pages/security/Services/authentication/authentication.service";
import {ProgressBarService} from "./pages/security/Services/authentication/progress-bar.service";

/**
 * @author Davood Akbari - 1399
 * daak1365@gmail.com
 * daak1365@yahoo.com
 * 09125188694
 */

@Component({
    selector: 'app-root',
    templateUrl: './app.component.html',
    styleUrls: ['./app.component.css']
})
export class AppComponent {
    show = false;

    display = false;

    items: MenuItem[] = [];

    currentUser: any = null;

    constructor(private authenticationService: AuthenticationService, private progressBarService: ProgressBarService) {
        this.authenticationService.user.subscribe(currentUser => this.currentUser = currentUser);
        this.progressBarService.progressBar.subscribe(isShow =>
            this.show = isShow
        );
    }

    ngOnInit() {
        this.items = [
            {
                label: 'جستجو ی پیشرفته',
                icon: 'pi pi-fw pi-search-plus',
                items: [
                    {
                        label: 'انتخاب جداول',
                        icon: 'pi pi-fw pi-book',
                        routerLink: ['/sql-editor']
                    },
                    {
                        label: 'ردیابی Ip',
                        icon: 'pi pi-fw pi-eye',
                        routerLink: ['/sql-editor']
                    }
                ]
            },
            {
                label: 'سامانه',
                icon: 'pi pi-fw pi-bookmark',
                items: [
                    {label: 'خانه', icon: 'pi pi-fw pi-sign-out', routerLink: ['/dashboard']},
                    {
                        label: 'خروج', icon: 'pi pi-fw pi-home', command: event => {
                            this.logOut()
                        }
                    },
                ]
            }
        ];
    }

    showMenu() {
        this.display = true;
    }

    logOut() {
        this.display = false;
        this.authenticationService.logOut();
    }

}
