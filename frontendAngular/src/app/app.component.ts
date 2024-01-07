import { Component, OnInit } from '@angular/core';
import { AuthService } from './service/auth.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent implements OnInit{
  title = 'HRMS-app';
  isLoggedIn : boolean = false;
  adminId: string| null=null;
  constructor(private authService: AuthService) { }
  ngOnInit(): void {
    this.isLoggedIn = this.authService.isAuthenticated();
    if (this.isLoggedIn) {
      const adminId = this.authService.getAdminId();
      if (adminId) {
        this.authService.setAdminId(adminId);
      }
    }
      
  }

  onAdminLoggedIn(adminId: string) {
    // Update adminId when the login component emits the event
    this.adminId = adminId;
    this.isLoggedIn = true;
  }
}
