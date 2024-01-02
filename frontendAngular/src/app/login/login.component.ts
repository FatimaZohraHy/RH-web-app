import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { JwtService } from 'src/app/service/jwt.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent implements OnInit {
  loginForm!: FormGroup;

  constructor(
    private service: JwtService,
    private fb: FormBuilder,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.loginForm = this.fb.group({
      email: ['', Validators.required, Validators.email],
      password: ['', Validators.required],
    });
  }

  submitForm() {
    this.service.login(this.loginForm.value).subscribe((response) => {
      console.log(response);
      if (response.jwToken != null) {
        alert('Hello, Your token is ' + response.jwToken);
        const jwtToken = response.jwToken;
        localStorage.setItem('jwt', jwtToken);

        // Decode the JWT token to get user roles
        const decodedToken = this.decodeJwt(jwtToken);

        // Check if ROLE_ADMIN exists in the roles
        if (decodedToken.roles && decodedToken.roles.includes('ROLE_ADMIN')) {
          this.router.navigateByUrl('/admin/dashboard');
        } else {
          this.router.navigateByUrl('/user/home');
        }
      }
    });
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
}
