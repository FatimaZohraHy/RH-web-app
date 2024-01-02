import { Component } from '@angular/core';
import { LogoutService } from '../service/logout.service';
import { HttpHeaders } from '@angular/common/http';

@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.css'],
})
export class SidebarComponent {
  http: any;
  constructor(private logoutService: LogoutService) {}

  isEmployeesDropdownOpen = false;
  isAttendanceDropdownOpen = false;
  isRequestsDropdownOpen = false;

  toggleEmployeesDropdown() {
    this.isEmployeesDropdownOpen = !this.isEmployeesDropdownOpen;
    this.isRequestsDropdownOpen = false;
    this.isAttendanceDropdownOpen = false;
  }

  toggleAttendanceDropdown() {
    this.isAttendanceDropdownOpen = !this.isAttendanceDropdownOpen;
    this.isRequestsDropdownOpen = false;
    this.isEmployeesDropdownOpen = false;
  }
  toggleRequestsDropdown() {
    this.isRequestsDropdownOpen = !this.isAttendanceDropdownOpen;
    this.isAttendanceDropdownOpen = false;
    this.isEmployeesDropdownOpen = false;
  }

  logout() {
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        Authorization: 'Bearer ' + localStorage.getItem('jwt'), // Include your token if needed
      }),
    };

    this.http.post('http://localhost:8087/logout', {}, httpOptions).subscribe(
      (response: any) => console.log(response),
      (error: any) => console.error(error)
    );
  }
}
