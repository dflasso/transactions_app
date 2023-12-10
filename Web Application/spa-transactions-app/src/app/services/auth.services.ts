import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { LoginRequest } from "../types/request/login.request";
import { environment } from "../../environments/environment";
import API_ROUTES from "../constants/api.routes";
import { LoginResponse } from "../types/responses/login.response";

@Injectable({
    providedIn: 'root'
})
export class AuthServices {

    constructor(private http: HttpClient) { }

    login(request: LoginRequest){
        const url = environment.authorizerBackend + API_ROUTES.AUTH.LOGIN;

        return this.http.post<LoginResponse>(url, request);
    }
}
