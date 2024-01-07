import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { AuthService } from 'src/app/service/auth.service';
import { DepartmentService } from 'src/app/service/department.service';

@Component({
  selector: 'app-show-departs',
  templateUrl: './show-departs.component.html',
  styleUrls: ['./show-departs.component.css'],
})
export class ShowDepartsComponent implements OnInit {
  adminId: string = '';
  departments: any[] = [];

  constructor(
    private route: ActivatedRoute,
    private deptService: DepartmentService,
    private authService: AuthService
  ) {}

  ngOnInit(): void {
    this.route.paramMap.subscribe((params) => {
      const adminId = this.authService.getAdminId();
      if (adminId) {
        this.adminId = adminId;
      }
      this.loadDepartments();
    });
  }
  loadDepartments() {
    this.deptService.getDepartments(this.adminId).subscribe((data) => {
      this.departments = data;
      console.log(data);
    });
  }

  deleteDepartment(departmentId: string): void {
    this.deptService.deleteDepartment(this.adminId, departmentId).subscribe(
      (response) => {
        // Handle successful deletion, e.g., refresh the department list
        console.log('Department deleted successfully', response);
      },
      (error) => {
        // Handle error, e.g., display an error message
        console.error('Error deleting department', error);
      }
    );
  }
}
