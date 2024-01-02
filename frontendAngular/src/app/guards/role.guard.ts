import { Injectable } from '@angular/core';
import {
  CanActivate,
  ActivatedRouteSnapshot,
  RouterStateSnapshot,
  UrlTree,
  Router,
} from '@angular/router';
import { Observable } from 'rxjs';
import { JwtService } from '../service/jwt.service';
import { AuthService } from '../service/auth.service';
@Injectable({
  providedIn: 'root',
})
export class RoleGuard implements CanActivate {
  constructor(
    private jwtService: JwtService,
    private authService: AuthService,
    private router: Router
  ) {}

  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot
  ):
    | Observable<boolean | UrlTree>
    | Promise<boolean | UrlTree>
    | boolean
    | UrlTree {
    
    const tokenRole = localStorage.getItem('jwt');
    if (tokenRole) {
      const decodedToken = this.authService.decodeJwt(tokenRole);
      if (decodedToken.roles.includes('ROLE_ADMIN')) {
        return true;
      } else {
        alert('You do not have permission to access this page');
        this.router.navigate(['/user/home']);
        return false;
      }
    }
    return false;
  }
}
