import {Inject, Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {API_PREFIX} from "../../../../app.token.d";
import {Observable} from "rxjs";
import {QueryResultVO} from "../vo/query-result.vo";

/**
 * @author Davood Akbari - 1399
 * daak1365@gmail.com
 * daak1365@yahoo.com
 * 09125188694
 */

@Injectable({
    providedIn: 'root'
})
export class QueryingService {
    private prefix: string = `${this.apiPrefix}/querying`;

    constructor(@Inject(API_PREFIX) private apiPrefix: string, private httpClient: HttpClient) {

    }

    public query(queryString: string): Observable<QueryResultVO> {
        return this.httpClient.post<QueryResultVO>(`${this.prefix}/query`, {query: queryString});
    }
}
