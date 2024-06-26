import { Component, AfterViewInit } from '@angular/core';
import { UserService } from '../../service/controller/user.service';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  loginForm: FormGroup;
  userName: string = '';
  password: string = '';

  constructor(private userService: UserService, private formBuilder: FormBuilder) {
    this.loginForm = this.formBuilder.group({
      userName: new FormControl(this.userName,[Validators.required]),
      password: new FormControl(this.password,[Validators.required])
    });
  }

  login(): void {
    if (this.loginForm.valid) {
      console.log('passo');
      console.log(this.loginForm.get('userName')?.value);
      console.log(this.loginForm.get('password')?.value);
      console.log(this.userService.login(this.loginForm.get('userName')?.value, this.loginForm.get('password')?.value));
    } else {
      // O formulário é inválido, não faz nada
    }
  }
}
