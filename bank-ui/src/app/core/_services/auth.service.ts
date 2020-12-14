import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {AppSetting} from '../../app.setting';
import {LoginRequest} from '../login-request';
import {Observable} from 'rxjs';
import {JwtResponse} from '../jwt-response';
import {SignupRequest} from '../signup-request';

const httpOptions = {
  headers: new HttpHeaders({'Content-Type': "application/json"})
};

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private loginUrl = AppSetting.SERVER_API_URL + 'auth/signin';
  private signupUrl = AppSetting.SERVER_API_URL + 'auth/signup';
  private logoutUrl = AppSetting.SERVER_API_URL + 'auth/logout'

  constructor(private http: HttpClient) { }

  attemptAuth(credentials: LoginRequest): Observable<JwtResponse> {
    return this.http.post<JwtResponse>(this.loginUrl, credentials, httpOptions);
  }
  signUp(info: SignupRequest): Observable<string> {
    return this.http.post<string>(this.signupUrl, info, httpOptions);
  }
  logout(): Observable<string> {
    return this.http.post<string>(this.logoutUrl, null, httpOptions);
  }
}
