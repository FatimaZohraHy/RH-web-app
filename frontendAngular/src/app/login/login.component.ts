import { Component, OnInit, EventEmitter, Output } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { JwtService } from 'src/app/service/jwt.service';
import { AuthService } from '../service/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent implements OnInit {
  loginForm!: FormGroup;
  @Output() adminLoggedIn: EventEmitter<string> = new EventEmitter();

  constructor(
    private service: JwtService,
    private fb: FormBuilder,
    private router: Router,
    private authService: AuthService
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
        const decodedToken = this.authService.decodeJwt(jwtToken);

        const adminId = decodedToken.userId;
        this.authService.setUserId(adminId);
        this.adminLoggedIn.emit(adminId);
        console.log('Admin ID:',adminId);
        this.router.navigateByUrl(`/admin/${adminId}/dashboard`);
      }
    });
  }
}
