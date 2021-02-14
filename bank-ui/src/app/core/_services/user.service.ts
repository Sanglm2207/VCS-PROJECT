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

  constructor() {}


  

 

  
}
