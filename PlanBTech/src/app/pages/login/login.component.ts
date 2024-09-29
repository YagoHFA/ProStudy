import { Component, AfterViewInit } from '@angular/core';
import { UserService } from '../../service/controller/user.service';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { UserlocalstorageService } from '../../service/localstorage/userlocalstorage.service';
import { MatDialog } from '@angular/material/dialog';
import { LoginFailedComponent } from '../../modals/login-failed/login-failed.component';
import { JwtService } from '../../service/controller/jwt.service';
import { jwtDecode } from 'jwt-decode';
import { timer } from 'rxjs';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  loginForm: FormGroup;
  userName: string = '';
  password: string = '';

  isLoading: boolean = false;

  constructor(private userService: UserService, private formBuilder: FormBuilder,
     private router:Router, private userStorage:UserlocalstorageService,
     public dialog:MatDialog, private jwtDecode:JwtService) {
    this.loginForm = this.formBuilder.group({
      userName: new FormControl(this.userName,[Validators.required]),
      password: new FormControl(this.password,[Validators.required])
    });

  }

  login(): void {
    this.isLoading = true;
    if (this.loginForm.valid) {
      this.userService.login(this.loginForm.get('userName')?.value, this.loginForm.get('password')?.value)
        .subscribe(
          (token:string) => {
            this.userStorage.setToken(token);
            this.userStorage.setUserName(this.jwtDecode.parseJwt(token).sub);
            this.router.navigate(['/homepage']);
          },
          (error:string)=>{
          this.openErrorDialog()
          this.isLoading = false;
          }
        );
    } else {
      // O formulário é inválido, não faz nada
    }
  }

  openErrorDialog(){
    this.dialog.open(LoginFailedComponent,{
      width: '500px',
      height: '200px'
    })
  }
}
