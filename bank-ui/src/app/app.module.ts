import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { LocationStrategy, HashLocationStrategy } from '@angular/common';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { PerfectScrollbarModule } from 'ngx-perfect-scrollbar';
import { PERFECT_SCROLLBAR_CONFIG } from 'ngx-perfect-scrollbar';
import { PerfectScrollbarConfigInterface } from 'ngx-perfect-scrollbar';
import { httpInterceptorProviders } from './core/_services/auth-interceptor';



const DEFAULT_PERFECT_SCROLLBAR_CONFIG: PerfectScrollbarConfigInterface = {
  suppressScrollX: true
};

import { AppComponent } from './app.component';

// Import containers
import {DefaultLayoutComponent, UserLayoutComponent } from './containers';

import { P404Component } from './views/error/404.component';
import { P500Component } from './views/error/500.component';
import { LoginComponent } from './views/login/login.component';
import { RegisterComponent } from './views/register/register.component';

const APP_CONTAINERS = [
  DefaultLayoutComponent,
  UserLayoutComponent
];

import {
  AppAsideModule,
  AppBreadcrumbModule,
  AppHeaderModule,
  AppFooterModule,
  AppSidebarModule,
} from '@coreui/angular';

// Import routing module
import { AppRoutingModule } from './app.routing';

// Import 3rd party components
import { BsDropdownModule } from 'ngx-bootstrap/dropdown';
import { TabsModule } from 'ngx-bootstrap/tabs';
import { ChartsModule } from 'ng2-charts';
import {FormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import { ToastrModule } from 'ngx-toastr';

///Admin page
import { AccountManagementModule } from './views/account-management/account-management.module';
import { UserManagementModule } from './views/user-management/user-management.module';
import { AuthGuard } from './core/_guard/auth.guard';
import { AdminGuard } from './core/_guard/admin.guard';
import { UserService } from './core/_services/user.service';


@NgModule({
    imports: [
        BrowserModule,
        BrowserAnimationsModule,
        AppRoutingModule,
        AppAsideModule,
        AppBreadcrumbModule.forRoot(),
        AppFooterModule,
        AppHeaderModule,
        AppSidebarModule,
        PerfectScrollbarModule,
        BsDropdownModule.forRoot(),
        TabsModule.forRoot(),
        ToastrModule.forRoot(), // ToastrModule added
        ChartsModule,
        FormsModule,
        HttpClientModule,
        AccountManagementModule,
        UserManagementModule

    ],
  declarations: [
    AppComponent,
    ...APP_CONTAINERS,
    P404Component,
    P500Component,
    LoginComponent,
    RegisterComponent
  ],
  providers: [
    httpInterceptorProviders,
    {provide: LocationStrategy, useClass: HashLocationStrategy},
    AuthGuard,
    AdminGuard,
    UserService
    ],  
  bootstrap: [ AppComponent ]
})
export class AppModule { }
