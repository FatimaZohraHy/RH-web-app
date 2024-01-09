import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { AuthService } from 'src/app/service/auth.service';
import { DepartmentService } from 'src/app/service/department.service';
import { DeptEmployeesComponent } from '../dept-employees/dept-employees.component';
import { EmployeesDataService } from 'src/app/service/employees-data.service';

@Component({
  selector: 'app-show-departs',
  templateUrl: './show-departs.component.html',
  styleUrls: ['./show-departs.component.css'],
})
export class ShowDepartsComponent implements OnInit {
  adminId: string = '';
  departments: any[] = [];
  employees: any[] = [];

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private deptService: DepartmentService,
    private authService: AuthService,
    private employeesDataService: EmployeesDataService
  ) {}

  ngOnInit(): void {
    this.route.paramMap.subscribe((params) => {
      const adminId = this.authService.getUserId();
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

  redirectToEmployeeList(deptId: string): void {

    this.router.navigate(['admin', this.adminId, 'show-departments', deptId, 'employees', 'getALL']);
    this.getEmployees(deptId);
  }

    getEmployees(deptId:string) {
      this.deptService.showdepartEmployees(this.adminId, deptId).subscribe((data) => {
        this.employeesDataService.setEmployees(data)
        console.log(data);
      });
  }
}
