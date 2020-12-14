import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../../core/_services/auth.service';
import { navItems } from '../../_nav';

@Component({
  selector: 'app-home',
  templateUrl: './default-layout.component.html'
})
export class DefaultLayoutComponent {

  public sidebarMinimized = false;
  public navItems = navItems;

  constructor(private httpClient: HttpClient,
              private authService: AuthService,
              private router: Router) {}

  toggleMinimize(e) {
    this.sidebarMinimized = e;
  }

  logout() {
    localStorage.clear();
    this.router.navigate(['/login']);
    // this.authService.logout().subscribe(
    //   s => {
    //     this.router.navigate(['/login']);
    //   }
    // )
  }

}
