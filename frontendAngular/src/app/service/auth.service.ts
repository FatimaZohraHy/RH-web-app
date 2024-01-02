// auth.service.ts

import { Injectable } from '@angular/core';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  constructor(private router: Router) { }
  token = localStorage.getItem('jwt');

  isAuthenticated(): boolean {
    if (this.token) {
      return true;
    } else {
      return false;
    }
  }

  decodeJwt(token: string): any {
    try {
      const base64Url = token.split('.')[1];
      const base64 = base64Url.replace(/-/g, '+').replace(/_/g, '/');
      return JSON.parse(atob(base64));
    } catch (e) {
      return {};
    }
  }

  logout(): void {
    localStorage.removeItem('jwt');
    this.router.navigateByUrl('/login');
  }

  // hasRole(expectedRole: string): boolean {
  //   // Example: Check if the user has the expected role
  //   const userRoles: string[] = /* Retrieve user roles from your authentication service */;
  //   return userRoles.includes(expectedRole);
  // }
}
