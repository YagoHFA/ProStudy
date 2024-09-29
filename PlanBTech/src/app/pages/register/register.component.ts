import { Component } from '@angular/core';
import { UserService } from '../../service/controller/user.service';
import { Router } from '@angular/router';
import { UserlocalstorageService } from '../../service/localstorage/userlocalstorage.service';
import { MatSnackBar } from '@angular/material/snack-bar';
import { catchError } from 'rxjs';
import { error } from 'console';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css'] // Note that this should be 'styleUrls' instead of 'styleUrl'
})
export class RegisterComponent {
  constructor(
    private userService: UserService,
    private userStorage: UserlocalstorageService,
    private router: Router,
    private snackBar: MatSnackBar
  ) { }

  userName: string = '';
  password: string = '';
  confirmPassword: string = '';
  email: string = '';

  isLoading: boolean = false;

  register() {
    // Verificar se as senhas coincidem
    var error = ""
    this.isLoading = true;
    try {
      if (this.password !== this.confirmPassword) {
        throw new Error('As senhas não coincidem.');
      }

      // Regex para validar o e-mail
      const emailRegex = /^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$/;
      if (!emailRegex.test(this.email)) {
        //this.snackBar.open('Por favor, insira um endereço de e-mail válido.', 'Fechar', { duration: 3000 });
        throw new Error('Por favor, insira um endereço de e-mail válido.');
      }

      // Regex para validar a senha
      const passwordRegex = /^(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,15}$/;
      if (!passwordRegex.test(this.password)) {
        //this.snackBar.open('A senha deve ter pelo menos 8 caracteres, incluindo pelo menos uma letra maiúscula, um número e um caractere especial.', 'Fechar', { duration: 3000 });
        throw new Error('A senha deve ter pelo menos 8 caracteres, \n incluindo pelo menos uma letra maiúscula, um número e um caractere especial.');
      }

      // Verifica se a senha é maior que 8 caracteres
      if (this.password.length < 8) {
        //this.snackBar.open('A senha deve ter pelo menos 8 caracteres.', 'Fechar', { duration: 3000 });
        throw new Error('A senha deve ter pelo menos 8 caracteres.');
      }

      // Verifica se a senha é menor que 16 caracteres
      if (this.password.length > 16) {
        //this.snackBar.open('A senha deve ter no máximo 16 caracteres.', 'Fechar', { duration: 3000 });
        throw new Error('A senha deve ter no máximo 16 caracteres.');
      }
      this.userService.register(this.userName, this.password, this.email).subscribe(
        response => {
          this.userService.login(this.userName, this.password).subscribe(
            (token: string) => {
              this.snackBar.open('Registro bem-sucedido!', 'Fechar', { duration: 3000 });
              this.userStorage.setToken(token);
              this.userStorage.setUserName(this.userName);
              this.router.navigate(['/homepage']);
            }
          );
        },
        (error: any) => {
          throw new Error(error);
        }
      );
    }
    catch (error: any) {
      this.snackBar.open('Erro ao registrar:', error.message, { duration: 3000 });
      this.isLoading = false;
    }
  }
}
