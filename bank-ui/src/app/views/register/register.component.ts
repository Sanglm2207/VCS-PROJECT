import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { SignupRequest } from '../../core/signup-request';
import { AuthService } from '../../core/_services/auth.service';
import { TokenStorageService } from '../../core/_services/token-storage.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  form: any = {};
  isSignUpFailed = false;
  errorMessage = '';
  roles: string[] = [];
  signupRequest: SignupRequest;
  formRequest: FormGroup;

  constructor(private authService: AuthService,
              private router: Router,
              private toastr: ToastrService) {}

  ngOnInit() {
    this.buildForm();
  }

  buildForm() {
    this.formRequest = new FormGroup({
      firstName: new FormControl(''),
      lastName: new FormControl(''),
      username: new FormControl(''),
      email: new FormControl(''),
      password: new FormControl(''),
    })
  }

  get f() {
    return this.formRequest.controls;
  }

  register() {
    this.authService.signUp(this.formRequest.value).subscribe(data => {
      this.toastr.success("Create user successfully")
      this.router.navigate(['/login']);
    }, error => {
      console.log(error);
      this.toastr.error("Create user failed")
      this.errorMessage = 'Username already exist';

    })
  }
}
