import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

// Import Containers
import { DefaultLayoutComponent, UserLayoutComponent } from './containers';

import { P404Component } from './views/error/404.component';
import { LoginComponent } from './views/login/login.component';
import { RegisterComponent } from './views/register/register.component';

export const routes: Routes = [
  {
    path: '',
    redirectTo: 'login',
    pathMatch: 'full',
  },
  {
    path: 'login',
    component: LoginComponent,
    data: {
      title: 'Login Page'
    }
  },
  {
    path: 'register',
    component: RegisterComponent,
    data: {
      title: 'Register Page'
    }
  },

  {
    path: 'user',
    component: UserLayoutComponent,
    data: {
      title: 'Home'
    },
    children: [
      
    ]
  },

  {
    path: 'admin',
    component: DefaultLayoutComponent,
    data: {
      title: 'Home'
    },
    children: [
      {
        path: 'accounts',
        loadChildren: () => import('./views/account-management/account-management.module').then(m => m.AccountManagementModule)
      },
      {
        path: 'users',
        loadChildren: () => import('./views/user-management/user-management.module').then(m => m.UserManagementModule)
      },
      {
        path: 'products',
        loadChildren: () => import('./views/product-management/product-management.module').then(m => m.ProductManagementModule)
      }
    ]
  },

  { path: '**', component: P404Component }
];

@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})
export class AppRoutingModule {}
