import { Component } from '@angular/core';
import { UserService } from '../../service/controller/user.service';
import { Router } from '@angular/router';
import { UserlocalstorageService } from '../../service/localstorage/userlocalstorage.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css'] // Note that this should be 'styleUrls' instead of 'styleUrl'
})
export class RegisterComponent {
  constructor(
    private userService: UserService,
    private userStorage: UserlocalstorageService,
    private router: Router
  ) {}

  userName: string = '';
  password: string = '';
  confirmPassword: string = '';
  email: string = '';

  register() {
    // Verificar se as senhas coincidem
    if (this.password !== this.confirmPassword) {
      window.alert('As senhas não coincidem.');
      return;
    }

    // Regex para validar o e-mail
    const emailRegex = /^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$/;
    if (!emailRegex.test(this.email)) {
      window.alert('Por favor, insira um endereço de e-mail válido.');
      return;
    }

    // Regex para validar a senha
    const passwordRegex = /^(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,15}$/;
    if (!passwordRegex.test(this.password)) {
      window.alert('A senha deve ter pelo menos 8 caracteres, incluindo pelo menos uma letra maiúscula, um número e um caractere especial.');
      return;
    }

    // Verifica se a senha é maior que 8 caracteres
    if (this.password.length < 8) {
      window.alert('A senha deve ter pelo menos 8 caracteres.');
      return;
    }

    // Verifica se a senha é menor que 16 caracteres
    if (this.password.length > 16) {
      window.alert('A senha deve ter no máximo 16 caracteres.');
      return;
    }

    this.userService.register(this.userName, this.password, this.email).subscribe(
      response => {
        console.log('Registro bem-sucedido:', response);
        window.alert('Registro bem-sucedido!');
        this.userService.login(this.userName, this.password).subscribe(
          (token: string) => {
            this.userStorage.setToken(token);
            this.router.navigate(['/homepage']);
          },
          (error: string) => console.error(error)
        );
      },
      error => {
        console.error('Erro ao registrar:', error);
      }
    );
  }
}