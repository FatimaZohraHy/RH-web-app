import { Component, OnInit, Input } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { AuthService } from 'src/app/service/auth.service';
import { DepartmentService } from 'src/app/service/department.service';
import { EmployeesDataService } from 'src/app/service/employees-data.service';

@Component({
  selector: 'app-dept-employees',
  templateUrl: './dept-employees.component.html',
  styleUrls: ['./dept-employees.component.css'],
})
export class DeptEmployeesComponent implements OnInit {
  employees: any[] = [];
  adminId: string = '';
  deptId: string = '';

  constructor(
    private route: ActivatedRoute,
    private authService: AuthService,
    private deptService: DepartmentService,
    private employeesDataService: EmployeesDataService
  ) {}
  ngOnInit(): void {
    this.route.paramMap.subscribe((params) => {
      const userId = this.authService.getUserId();
      if (userId) {
        this.adminId = userId;
      }
    });

    this.employeesDataService.employees$.subscribe((employees) => {
      this.employees = employees;
    });

    this.employeesDataService.deptId$.subscribe((id) => {
      this.deptId = id;
    })
  }
  deleteEmployee(EmplId: string):void {
    this.deptService.deleteEmployee(this.adminId, this.deptId, EmplId).subscribe(
        (response) => {
          console.log('Employee deleted successfully',response);
          alert('Employee deleted successfully');
        },
        (error) => {
          console.error('Error deleting employee:', error);
        }
      );
  }
}