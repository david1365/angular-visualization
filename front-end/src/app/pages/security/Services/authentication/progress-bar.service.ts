import {Injectable} from '@angular/core';
import {BehaviorSubject, Observable} from "rxjs";

/**
 * @author Davood Akbari - 1399
 * daak1365@gmail.com
 * daak1365@yahoo.com
 * 09125188694
 */

@Injectable({
    providedIn: 'root'
})
export class ProgressBarService {
    private progressBarSubject: BehaviorSubject<boolean>;
    public progressBar: Observable<boolean>;
    public show: boolean = false;

    constructor() {
        this.progressBarSubject = new BehaviorSubject<boolean>(this.show);
        this.progressBar = this.progressBarSubject.asObservable();

    }

    showBar() {
        this.show = true;

        // @ts-ignore
        this.progressBarSubject.next(this.show);
    }

    hideBar() {
        this.show = false;

        // @ts-ignore
        this.progressBarSubject.next(this.show);
    }
}
