import { Component } from '@angular/core';
import { FormControl, FormsModule, ReactiveFormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthServices } from '../../services/auth.services';
import { LOCAL_STORAGE_ITEMS } from '../../constants/local-storage-items.enum';

@Component({
  selector: 'app-login-form',
  standalone: true,
  imports: [ReactiveFormsModule, FormsModule],
  templateUrl: './login-form.component.html',
  styleUrl: './login-form.component.css'
})
export class LoginFormComponent {
  username = new FormControl('');
  password = new FormControl('');
  invalidCredential = false;

  constructor(
    private router: Router,
    private authServices: AuthServices) { }

  singin() {
    this.authServices.login({ password: this.password.value || "", usernameOrEmail: this.username.value || "" })
      .subscribe({
        next: response => {
          localStorage.setItem(LOCAL_STORAGE_ITEMS.TOKEN, `${response.type} ${response.token}`);
          this.router.navigate(['/transactions'])
        },
        error: () => {
          this.invalidCredential = true;
        }
      })

  }
}
