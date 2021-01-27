import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {AppSetting, TOKEN_NAME} from '../../app.setting';
import {User} from '../_models/User.model';
import {JwtHelper} from 'angular2-jwt';
// import {UserProfileModel} from '../_models/UserProfile.model';
import {TokenStorageService} from './token-storage.service';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  baseUrl = AppSetting.SERVER_API_URL;
  username: string;
  jwtHelper: JwtHelper = new JwtHelper();
  isAdmin: boolean;
  accessToken: string;

  constructor() {}


  login(accessToken: string) {
    const decodedToken = this.jwtHelper.decodeToken(accessToken);
    console.log(decodedToken);

    this.isAdmin = decodedToken.authorities.some(e1 => e1 ==='ADMIN');
    this.accessToken = accessToken;

    localStorage.setItem(TOKEN_NAME, accessToken);
    
  }

  logout() {
    this.accessToken = null;
    this.isAdmin = false;
    localStorage.removeItem(TOKEN_NAME);
  }
  isAdminUser(): boolean {
    return this.isAdmin;
  }

  isUser(): boolean {
    return !this.isAdmin;
  }
}
