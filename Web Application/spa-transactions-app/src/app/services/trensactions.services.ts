import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { ITransactionsByCodeAndTypePersonRequest } from "../types/request/transactions-by-code-and-type-person.requests";
import API_ROUTES from "../constants/api.routes";
import { ITransactionsByCodeAndTypeResponse } from "../types/responses/transactions-by-code-and-type-person.response";

@Injectable({
    providedIn: 'root'
})
export class TransactionsServices {

    constructor(private http: HttpClient) { }

    getAllByCodeAndTypePerson(request: ITransactionsByCodeAndTypePersonRequest) {
        const url = API_ROUTES.TRANSACTIONS.GET_BY_CODE_AND_TYPE_PERSON(request.code, request.type);

        return this.http.get<ITransactionsByCodeAndTypeResponse>("http://localhost:8080" + url);
    }
}
