import { Component } from '@angular/core';
import { UserService } from '../../service/controller/user.service';
import { Router } from '@angular/router';
import { UserlocalstorageService } from '../../service/localstorage/userlocalstorage.service';
import { MatSnackBar } from '@angular/material/snack-bar';
import { catchError } from 'rxjs';

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
  ) {}

  userName: string = '';
  password: string = '';
  confirmPassword: string = '';
  email: string = '';

  register() {
    // Verificar se as senhas coincidem
    if (this.password !== this.confirmPassword) {
      this.snackBar.open('As senhas não coincidem.', 'Fechar', { duration: 3000 });
      return;
    }

    // Regex para validar o e-mail
    const emailRegex = /^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$/;
    if (!emailRegex.test(this.email)) {
      this.snackBar.open('Por favor, insira um endereço de e-mail válido.', 'Fechar', { duration: 3000 });
      return;
    }

    // Regex para validar a senha
    const passwordRegex = /^(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,15}$/;
    if (!passwordRegex.test(this.password)) {
      this.snackBar.open('A senha deve ter pelo menos 8 caracteres, incluindo pelo menos uma letra maiúscula, um número e um caractere especial.', 'Fechar', { duration: 3000 });
      return;
    }

    // Verifica se a senha é maior que 8 caracteres
    if (this.password.length < 8) {
      this.snackBar.open('A senha deve ter pelo menos 8 caracteres.', 'Fechar', { duration: 3000 });
      return;
    }

    // Verifica se a senha é menor que 16 caracteres
    if (this.password.length > 16) {
      this.snackBar.open('A senha deve ter no máximo 16 caracteres.', 'Fechar', { duration: 3000 });
      return;
    }
    this.userService.register(this.userName, this.password, this.email).subscribe(
      response => {
        console.log('Registro bem-sucedido:', response);
        this.snackBar.open('Registro bem-sucedido!', 'Fechar', { duration: 3000 });
        this.userService.login(this.email, this.password).subscribe(
          (token: string) => {
            this.userStorage.setToken(token);
            this.userStorage.setUserName(this.userName);
            this.router.navigate(['/homepage']);
          }
        );
      },
      (error:any) => {
        console.error('Erro ao registrar:', error);
        this.snackBar.open("Não foi possível realizar o cadastro", 'Fechar', { duration: 3000 });
      }
    );
  }
}
