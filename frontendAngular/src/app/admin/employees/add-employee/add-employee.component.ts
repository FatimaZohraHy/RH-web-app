import { Component, OnInit } from '@angular/core';
import { FormGroup,FormBuilder, Validators, AsyncValidatorFn, ValidationErrors, AbstractControl } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Observable, debounceTime, of, switchMap } from 'rxjs';
import { AuthService } from 'src/app/service/auth.service';
import { DepartmentService } from 'src/app/service/department.service';
import { EmployeesDataService } from 'src/app/service/employees-data.service';

@Component({
  selector: 'app-add-employee',
  templateUrl: './add-employee.component.html',
  styleUrls: ['./add-employee.component.css'],
})
export class AddEmployeeComponent implements OnInit {
  addEmployeeForm!: FormGroup;
  adminId: string = '';
  departments: any[] = [];
  private readonly FORM_CONTROLS = {
    FIRST_NAME: 'firstName',
    LAST_NAME: 'lastName',
    POST: 'post',
    EMAIL: 'email',
    PHONE: 'phone',
    BDATE: 'bdate',
    ADDRESS: 'address',
    CITY: 'city',
    GENDER: 'gender',
    DEPARTMENT: 'department',
    JDATE: 'jdate',
    IS_ACTIVE: 'isActive',
    PASSWORD: 'password',
    SALAIRE: 'salaire',
    PAY_DAY: 'pay_day',
  };

  constructor(
    private fb: FormBuilder,
    private deptService: DepartmentService,
    private authService: AuthService,
    private route: ActivatedRoute,
    private employeesData: EmployeesDataService
  ) {}
  ngOnInit(): void {
    this.addEmployeeForm = this.fb.group({
      [this.FORM_CONTROLS.FIRST_NAME]: ['', Validators.required],
      [this.FORM_CONTROLS.LAST_NAME]: ['', Validators.required],
      [this.FORM_CONTROLS.POST]: ['', Validators.required],
      [this.FORM_CONTROLS.EMAIL]: ['', [Validators.required, Validators.email]],
      [this.FORM_CONTROLS.PHONE]: ['', Validators.required],
      [this.FORM_CONTROLS.BDATE]: ['', Validators.required],
      [this.FORM_CONTROLS.ADDRESS]: ['', Validators.required],
      [this.FORM_CONTROLS.CITY]: ['', Validators.required],
      [this.FORM_CONTROLS.GENDER]:['',Validators.required],
      [this.FORM_CONTROLS.DEPARTMENT]: ['', Validators.required],
      [this.FORM_CONTROLS.JDATE]: ['', Validators.required],
      [this.FORM_CONTROLS.IS_ACTIVE]: ['', Validators.required],
      [this.FORM_CONTROLS.PASSWORD]: [
        '',
        [Validators.required, Validators.minLength(8)],
      ],
      [this.FORM_CONTROLS.SALAIRE]: ['', Validators.required],
      [this.FORM_CONTROLS.PAY_DAY]: ['', Validators.required],
    });

    this.route.paramMap.subscribe((params) => {
      const userId = this.authService.getUserId();
      if (userId) {
        this.adminId = userId;
        this.getdepts();
      }
    });
  }
  addEmployee() {
    const employeeData = this.addEmployeeForm.value;
    const deptId = this.addEmployeeForm.get(
      this.FORM_CONTROLS.DEPARTMENT
    )?.value;
    const date = this.addEmployeeForm.get(this.FORM_CONTROLS.JDATE)?.value;
    console.log(date);
    const payload = {
      firstName: employeeData[this.FORM_CONTROLS.FIRST_NAME],
      lastName: employeeData[this.FORM_CONTROLS.LAST_NAME],
      post: employeeData[this.FORM_CONTROLS.POST],
      email: employeeData[this.FORM_CONTROLS.EMAIL],
      phone: employeeData[this.FORM_CONTROLS.PHONE],
      bdate: employeeData[this.FORM_CONTROLS.BDATE],
      address: employeeData[this.FORM_CONTROLS.ADDRESS],
      city: employeeData[this.FORM_CONTROLS.CITY],
      gender: employeeData[this.FORM_CONTROLS.GENDER],
      department: deptId,
      jdate: employeeData[this.FORM_CONTROLS.JDATE],
      isActive: employeeData[this.FORM_CONTROLS.IS_ACTIVE],
      password: employeeData[this.FORM_CONTROLS.PASSWORD],
      salaire: {
        salaire: employeeData[this.FORM_CONTROLS.SALAIRE],
        pay_day: employeeData[this.FORM_CONTROLS.PAY_DAY],
      },
    };
    this.employeesData.addEmployee(this.adminId, deptId, payload).subscribe(
      (response) => {
        console.log('Employee added successfully:', response);
        alert('Employee Added successfully');
        this.addEmployeeForm.reset();
      },
      (error) => {
        console.error('Error adding employee:', error);
        alert('Error adding employee');
      }
    );
  }

  getdepts() {
    this.deptService.getDepartments(this.adminId).subscribe(
      (departments) => {
        this.departments = departments;
      },
      (error) => {
        console.error('Error fetching departments:', error);
      }
    );
  }
}
