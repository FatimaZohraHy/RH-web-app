import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AuthService } from './auth.service';

@Injectable({
  providedIn: 'root',
})
export class RequestsService {
  private apiUrl = 'http://localhost:8087/admin';

  constructor(
    private http: HttpClient,
    private authService: AuthService
  ) { }
  adminId = this.authService.getUserId();
  getResignations(): Observable<any>{
    const url = `${this.apiUrl}/${this.adminId}/requests/resignations/getAll`;
    return this.http.get(url);
  }

}
