import { Component, Input, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Accounts } from '../../../core/_models/Account.model';
import { AccountService } from '../../../core/_services/account.service';

@Component({
  selector: 'app-edit-account',
  templateUrl: './edit-account.component.html',
  styleUrls: ['./edit-account.component.css']
})
export class EditAccountComponent implements OnInit {
  @Input() dataEdit;
  accounts: Accounts;
  editForm: FormGroup;

  constructor(private fb:FormBuilder,
              private router: Router,
              private accountService: AccountService,
              private toastr: ToastrService) { }

  ngOnInit(): void {
    this.buildForm();
    this.getAccountById();
  }

  buildForm() {
    this.editForm = this.fb.group({
      id: [''],
      accountNumber: ['', Validators.required],
      balance: ['', Validators.required],
      firstname: ['', Validators.required],
      lastname: ['', Validators.required],
      age:['', Validators.required],
      gender: ['', Validators.required],
      address: ['', Validators.required],
      employer: ['', Validators.required],
      email: ['', Validators.required],
      city: ['', Validators.required],
      state: ['', Validators.required],
    })
  }

  onSubmit() {
    this.accountService.editAccount(this.editForm.value.id, this.editForm.value)
      .subscribe(
        data => {
          this.toastr.success('Account updated successfully.');
          console.log(data);
          this.refreshPage();
        },
        error => {
          this.toastr.error('Update Failed!')
        });
  }

  getAccountById() {
    this.editForm.setValue(this.dataEdit);
    // let accountId = this.dataEdit.id;

    // this.accountService.getAccount(accountId)
    //   .subscribe( data => {
    //     this.editForm.setValue(data);
    //     console.log(data);

    //   });
  }

  refreshPage() {
    window.location.reload();
  }
}
