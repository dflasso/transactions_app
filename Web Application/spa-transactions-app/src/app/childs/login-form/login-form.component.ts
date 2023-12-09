import { Component } from '@angular/core';
import {  FormsModule } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-login-form',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './login-form.component.html',
  styleUrl: './login-form.component.css'
})
export class LoginFormComponent {
  username = '';
  password = '';

  constructor(
    private route: ActivatedRoute,
    private router: Router ) {}

  singin() {
    this.router.navigate(['/transactions'])
  }
}
