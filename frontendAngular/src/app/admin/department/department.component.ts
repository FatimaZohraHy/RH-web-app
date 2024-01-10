import { Component, Input } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AuthService } from 'src/app/service/auth.service';
import { DepartmentService } from 'src/app/service/department.service';

@Component({
  selector: 'app-department',
  templateUrl: './department.component.html',
  styleUrls: ['./department.component.css'],
})
export class DepartmentComponent {
  departForm: FormGroup;
  adminId: string;

  constructor(
    private fb: FormBuilder,
    private departmentService: DepartmentService,
    private authService: AuthService
  ) {
    this.departForm = this.fb.group({
      departName: ['', Validators.required,],
      departDetails:['',Validators.required,],
    });
    this.adminId = this.authService.getUserId()!;
  }

  onSubmit() {
    if (this.departForm.valid) {
      // Perform form submission logic here
      const formData = this.departForm.value;

      this.departmentService.addDepartment(this.adminId, formData).subscribe(
        (response) => {
          // Handle success (optional)
          console.log('Department added successfully:', response);

          // You can reset the form or perform other actions here
          this.departForm.reset();
        },
        (error) => {
          // Handle error (optional)
          alert('Department added')
          this.departForm.reset();
          console.error('Error adding department:', error);
        }
      );
    }
  }

}
