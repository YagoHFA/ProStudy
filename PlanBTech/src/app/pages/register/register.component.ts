import { Component } from '@angular/core';
import { UserService } from '../../service/controller/user.service';
import { Router } from '@angular/router';
import { UserlocalstorageService } from '../../service/localstorage/userlocalstorage.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrl: './register.component.css'
})
export class RegisterComponent {
  constructor(private userService:UserService,
    private userStorage:UserlocalstorageService,
    private router:Router
  ){}
  userName: string = '';
  password: string= '';
  confirmPassword: string= '';
  email: string='';
  register() {
    // Verificar se as senhas coincidem
    if (this.password !== this.confirmPassword) {
      window.alert('As senhas não coincidem.');
      return;
    }

    this.userService.register(this.userName, this.password, this.email).subscribe(
      response => {
        console.log('Registro bem-sucedido:', response);
        window.alert('Registro bem-sucedido!');
        this.userService.login(this.userName, this.password)
        .subscribe(
          (token:string) => {
            this.userStorage.setToken(token);
            this.router.navigate(['/homepage']);
          },
          (error:string)=>
            console.error(error)
        );
        // Redirecionar ou realizar outra ação após o registro
      },
      error => {
        console.error('Erro ao registrar:', error);
      }
    );
  }
}
