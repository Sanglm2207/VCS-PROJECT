import { Component, OnInit, ViewChild } from '@angular/core';
import { FormControl } from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { ActivatedRoute } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Accounts } from '../../core/_models/Account.model';
import { AccountService } from '../../core/_services/account.service';
import { CreateAccountComponent } from './create-account/create-account.component';
import { EditAccountComponent } from './edit-account/edit-account.component';



@Component({
  selector: 'app-account-management',
  templateUrl: './account-management.component.html',
  styleUrls: ['./account-management.component.css']
})
export class AccountManagementComponent implements OnInit {

  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;

  //accounts: Accounts[] = [];
  public accounts = new MatTableDataSource();

  displayedColumns = ['id', 'lastname', 'firstname', 'accountNumber', 'balance','actions'];

  myControl = new FormControl();




  constructor(private accountService: AccountService,
              private route: ActivatedRoute,
              public dialog: MatDialog,
              private toastr: ToastrService) { }


  ngAfterViewInit() {
    // add ngAfterViewInit hook
        this.accounts.paginator = this.paginator;
        this.accounts.sort = this.sort;
  }


  ngOnInit(){
    this.getAllAccounts();


  }



  getAllAccounts() {
    this.accountService.getAllAccounts().subscribe(
      data => {
        console.log(data);
        this.accounts.data = data
      }
    )

  }

  openAddDialog() {
    const dialogRef = this.dialog.open(CreateAccountComponent);

    dialogRef.afterClosed().subscribe(result => {
      console.log(`Dialog result: ${result}`);
    });
  }

  openEditDialog(event: any) {
    console.log("data: " + event.id);
    const dialogRef = this.dialog.open(EditAccountComponent);
    dialogRef.componentInstance.dataEdit= event;

    dialogRef.afterClosed().subscribe(result => {
      console.log(`Dialog result: ${result}`);
    });
  }

  deleteAccount(id: number) {
    this.accountService.deleteAccount(id).subscribe(data => {
      console.log(data);
      this.toastr.success("Deleted account successfully!")
      window.location.reload();
    })
  }
}
