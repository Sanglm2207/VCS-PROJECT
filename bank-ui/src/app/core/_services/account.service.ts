import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AppSetting } from '../../app.setting';
import { Accounts } from '../_models/Account.model';

@Injectable({
  providedIn: 'root'
})
export class AccountService {

  baseUrl = AppSetting.SERVER_API_URL;

  constructor(private http: HttpClient) { }

  getAllAccounts(): Observable<Accounts[]>{
   return this.http.get<Accounts[]>(this.baseUrl + 'accounts/getAllAccounts');
  }

  createAccount(Accounts: Object): Observable<Accounts[]>{
    return this.http.post<Accounts[]>(this.baseUrl + 'accounts/createAccount', Accounts);
  }

  editAccount(id: number, Accounts: Object): Observable<Accounts[]> {
    return this.http.put<Accounts[]>(this.baseUrl + 'accounts/editAccount/' + id, Accounts);
  }

  getAccount(id: number): Observable<Accounts[]> {
    return this.http.get<Accounts[]>(this.baseUrl + 'accounts/getAccount/' + id);
  }

  deleteAccount(id: number): Observable<Accounts[]> {
    return this.http.delete<Accounts[]>(this.baseUrl + 'accounts/deleteAccount/' + id)
  }
}
