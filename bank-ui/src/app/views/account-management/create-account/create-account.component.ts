import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { AccountService } from '../../../core/_services/account.service';

@Component({
  selector: 'app-create-user',
  templateUrl: './create-account.component.html',
  styleUrls: ['./create-account.component.css']
})
export class CreateAccountComponent implements OnInit {

  hide = true;

  addForm: FormGroup;



  constructor(private accountService: AccountService,
              private router: Router,
              private fb: FormBuilder,
              private toastr: ToastrService) { }

  ngOnInit() {
    this.buildForm();
  }


  buildForm() {
    this.addForm = this.fb.group({
      accountNumber: ['', Validators.required],
      balance: ['', Validators.required],
      firstname: ['', Validators.required],
      lastname: ['', Validators.required],
      age:['', Validators.required],
      gender: ['M', Validators.required],
      address: ['', Validators.required],
      employer: ['', Validators.required],
      email: ['', Validators.required],
      city: ['', Validators.required],
      state: ['', Validators.required],
    })
  }


  get f() {
    return this.addForm.controls;
  }

  onSubmit() {
    this.accountService.createAccount(this.addForm.value)
      .subscribe(
        data => {
          console.log(data);
          this.toastr.success('Thêm mới thành công');
          this.refreshPage();
        },
        error => {
          console.log(error);
          this.toastr.error('Thêm mới thất bại !');
        }
      );
  }

  refreshPage() {
    window.location.reload();
  }




}
