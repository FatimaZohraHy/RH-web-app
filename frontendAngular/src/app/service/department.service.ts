import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class DepartmentService {
  private apiUrl = 'http://localhost:8087/admin';

  constructor(private http: HttpClient) {}

  addDepartment(adminId: string, data: any): Observable<any> {
    return this.http.post(`${this.apiUrl}/${adminId}/departement/add`, data);
  }

  getDepartments(adminId: string): Observable<any[]> {
    const url = `${this.apiUrl}/${adminId}/departement/getAll`;
    return this.http.get<any[]>(url);
  }
  deleteDepartment(adminId: string, departmentId: string): Observable<any> {
    const url = `${this.apiUrl}/${adminId}/departemet/delete/${departmentId}`;
    const headers = new HttpHeaders({
      'Content-Type': 'application/json',
      // Add any other required headers here
    });
    return this.http.delete(url, { headers});
  }
}
