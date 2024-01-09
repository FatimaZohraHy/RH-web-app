import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class EmployeesDataService {
  private employeesSource = new BehaviorSubject<any[]>([]);
  employees$ = this.employeesSource.asObservable();

  setEmployees(employees: any[]): void{
    this.employeesSource.next(employees);
  }

  constructor() {}
}
