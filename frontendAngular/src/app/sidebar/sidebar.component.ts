import { Component } from '@angular/core';

@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.css'],
})
export class SidebarComponent {
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
}
