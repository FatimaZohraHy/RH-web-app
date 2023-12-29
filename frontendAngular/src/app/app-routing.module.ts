import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { AddEmployeeComponent } from './employees/add-employee/add-employee.component';
import { DepartmentComponent } from './department/department.component';
import { AttendanceComponent } from './attendance/attendance.component';
import { LeavesComponent } from './requests/leaves/leaves.component';
import { ResignationsComponent } from './requests/resignations/resignations.component';
import { ClaimsComponent } from './claims/claims.component';
import { PayrollComponent } from './payroll/payroll.component';

const routes: Routes = [
  { path: '', redirectTo: '/dashboard', pathMatch: 'full' },
  { path: 'dashboard', component: DashboardComponent },
  { path: 'login', component: LoginComponent },
  { path: 'employees/add-employee', component: AddEmployeeComponent },
  { path: 'department', component: DepartmentComponent },
  { path: 'attendance', component: AttendanceComponent },
  { path: 'requests/leaves', component: LeavesComponent },
  { path: 'requests/resignations', component: ResignationsComponent },
  { path: 'claims', component: ClaimsComponent },
  { path: 'payroll', component: PayrollComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
