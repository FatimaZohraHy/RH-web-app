import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SidebarComponent } from './sidebar/sidebar.component';
import { NavbarComponent } from './navbar/navbar.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { LoginComponent } from './login/login.component';
import { EmployeesComponent } from './employees/employees.component';
import { AddEmployeeComponent } from './employees/add-employee/add-employee.component';
import { ArchiveEmployeeComponent } from './employees/archive-employee/archive-employee.component';
import { DepartmentComponent } from './department/department.component';
import { CardComponent } from './department/card/card.component';
import { AttendanceComponent } from './attendance/attendance.component';
import { LeavesComponent } from './requests/leaves/leaves.component';
import { ResignationsComponent } from './requests/resignations/resignations.component';
import { ClaimsComponent } from './claims/claims.component';
import { PayrollComponent } from './payroll/payroll.component';

@NgModule({
  declarations: [
    AppComponent,
    SidebarComponent,
    NavbarComponent,
    DashboardComponent,
    LoginComponent,
    EmployeesComponent,
    AddEmployeeComponent,
    ArchiveEmployeeComponent,
    DepartmentComponent,
    CardComponent,
    AttendanceComponent,
    LeavesComponent,
    ResignationsComponent,
    ClaimsComponent,
    PayrollComponent,
  ],
  imports: [BrowserModule, AppRoutingModule, ReactiveFormsModule, HttpClientModule ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
