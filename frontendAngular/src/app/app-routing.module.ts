import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { DashboardComponent } from './admin/dashboard/dashboard.component';
import { AddEmployeeComponent } from './admin/employees/add-employee/add-employee.component';
import { AttendanceComponent } from './admin/attendance/attendance.component';
import { ClaimsComponent } from './admin/claims/claims.component';
import { PayrollComponent } from './admin/payroll/payroll.component';
import { DepartmentComponent } from './admin/department/department.component';
import { LeavesComponent } from './admin/requests/leaves/leaves.component';
import { ResignationsComponent } from './admin/requests/resignations/resignations.component';
import { LoginComponent } from './login/login.component';
import { ArchiveEmployeeComponent } from './admin/employees/archive-employee/archive-employee.component';
import { HomeComponent } from './user/home/home.component';
import { AdminComponent } from './admin/admin.component';
import { UserComponent } from './user/user.component';
import { UserClaimsComponent } from './user/user-claims/user-claims.component';
import { UserPayrollComponent } from './user/user-payroll/user-payroll.component';
import { UserRequestsComponent } from './user/user-requests/user-requests.component';
import { CheckinComponent } from './user/userattendance/checkin/checkin.component';
import { CheckoutComponent } from './user/userattendance/checkout/checkout.component';
import { ProfilComponent } from './user/profil/profil.component';
import { UserLeaveComponent } from './user/user-requests/user-leave/user-leave.component';
import { UserResignComponent } from './user/user-requests/user-resign/user-resign.component';
import { AuthGuard } from './guards/auth.guard';
import { RoleGuard } from './guards/role.guard';


const routes: Routes = [
  { path: '', redirectTo: '/login', pathMatch: 'full' },
  {
    path: 'admin',
    component: AdminComponent,
    canActivate: [AuthGuard, RoleGuard],
    data: { expectedRole: 'ROLE_ADMIN' },
    children: [
      { path: 'dashboard', component: DashboardComponent },
      { path: 'employees/add-employee', component: AddEmployeeComponent },
      {
        path: 'employees/archive-employee',
        component: ArchiveEmployeeComponent,
      },
      { path: 'department', component: DepartmentComponent },
      { path: 'attendance', component: AttendanceComponent },
      { path: 'requests/leaves', component: LeavesComponent },
      { path: 'requests/resignations', component: ResignationsComponent },
      { path: 'claims', component: ClaimsComponent },
      { path: 'payroll', component: PayrollComponent },
    ],
  },
  {
    path: 'user',
    component: UserComponent,
    canActivate:[AuthGuard],
    children: [
      { path: 'home', component: HomeComponent },
      { path: 'claims', component: UserClaimsComponent },
      { path: 'payroll', component: UserPayrollComponent },
      { path: 'checkin', component: CheckinComponent },
      { path: 'checkout', component: CheckoutComponent },
      { path: 'profile', component: ProfilComponent },
      { path: 'requests/leave', component: UserLeaveComponent },
      { path: 'requests/resign', component: UserResignComponent },
    ],
  },
  { path: 'login', component: LoginComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
