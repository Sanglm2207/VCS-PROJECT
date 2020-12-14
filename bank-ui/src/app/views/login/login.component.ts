import {Component, OnInit} from '@angular/core';
import { Router } from '@angular/router';
import {LoginRequest} from '../../core/login-request';
import {AuthService} from '../../core/_services/auth.service';
import {TokenStorageService} from '../../core/_services/token-storage.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: 'login.component.html'
})
export class LoginComponent implements OnInit{
  form: any = {};
  isLoggedIn = false;
  isLoginFailed = false;
  errorMessage = '';
  roles: string[] = [];
  private loginRequest: LoginRequest;

  constructor(private authService: AuthService,
              private tokenStorage: TokenStorageService,
              private router: Router) {}

  ngOnInit() {
    if (this.tokenStorage.getToken()) {
      this.isLoggedIn = true;
      this.roles = this.tokenStorage.getAuthorities();
    }
  }
  onSubmit() {
    console.log(this.form);

    this.loginRequest = new LoginRequest(
      this.form.username,
      this.form.password);

    this.authService.attemptAuth(this.loginRequest).subscribe(
      data => {
        this.tokenStorage.saveToken(data.accessToken);
        this.tokenStorage.saveUsername(data.username);
        this.tokenStorage.saveAuthorities(data.authorities);

        this.isLoginFailed = false;
        this.isLoggedIn = true;
      //  console.log('role', this.tokenStorage.getAuthorities());
        //this.roles = this.tokenStorage.getAuthorities();
        // this.reloadPage();
        this.router.navigate(['/admin']);
      },
      error => {
        console.log(error);
        this.errorMessage = error.error.message;
        this.isLoginFailed = true;
      }
    );
  }

  reloadPage() {
    window.location.reload();
  }
}
