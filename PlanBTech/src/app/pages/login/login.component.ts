import { Component, AfterViewInit } from '@angular/core';
import { UserService } from '../../service/controller/user.service';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { UserlocalstorageService } from '../../service/localstorage/userlocalstorage.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  loginForm: FormGroup;
  userName: string = '';
  password: string = '';

  constructor(private userService: UserService, private formBuilder: FormBuilder, private router:Router, private userStorage:UserlocalstorageService) {
    this.loginForm = this.formBuilder.group({
      userName: new FormControl(this.userName,[Validators.required]),
      password: new FormControl(this.password,[Validators.required])
    });
  }

  login(): void {
    if (this.loginForm.valid) {
      this.userService.login(this.loginForm.get('userName')?.value, this.loginForm.get('password')?.value)
        .subscribe(
          (token:string) => {
            this.userStorage.setToken(token);
            this.userStorage.setUserName(this.loginForm.get('userName')?.value);
            this.router.navigate(['/homepage']);
          },
          (error:string)=>
            console.error(error)
        );
    } else {
      // O formulário é inválido, não faz nada
    }
  }
}
