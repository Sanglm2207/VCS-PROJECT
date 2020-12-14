import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {AppSetting} from '../../app.setting';
import {User} from '../_models/User.model';
// import {UserProfileModel} from '../_models/UserProfile.model';
import {TokenStorageService} from './token-storage.service';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  baseUrl = AppSetting.SERVER_API_URL;
  username: string;
  constructor(private http: HttpClient,private tokenStorage: TokenStorageService) {}

  // getCurrentUser() {
  //   return this.http.get<User>(this.baseUrl + 'users/me')
  // }

  // getUSerProfile() {
  //   this.username = this.tokenStorage.getUsername();
  //   return this.http.get<UserProfileModel>(this.baseUrl + this.username + '/' + 'profile')
  // }
}
