import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { catchError, Observable, throwError, map, switchMap } from 'rxjs';
import { UserFull } from '../../class/model/user-full';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http:HttpClient,
              private route:ActivatedRoute
  ) { }

  login(userName: string, password: string): Observable<string> {
    const user = { userName, password }; // Usando shorthand property notation
    const url = `https://prostudy-api.azurewebsites.net/auth/login`;
    //const url = `http://localhost:8080/auth/login`;
    return this.http.post<any>(url, user).pipe(
      catchError((error: HttpErrorResponse) => {
        let errorMessage = 'Ocorreu um erro desconhecido.';

        if (error.error instanceof ErrorEvent) {
          // Erro no cliente
          errorMessage = `Erro: ${error.error.message}`;
        } else {
          // Erro no servidor
          errorMessage = `Erro: ${error.status}, Mensagem: ${error.message}`;
        }

        // Aqui você pode implementar uma lógica mais sofisticada para lidar com erros, como redirecionar o usuário para uma página de erro
        ///console.error(errorMessage);
        //window.alert(errorMessage);
        return throwError(() => new Error(errorMessage));
      }),

      map((token: any) => token.token) // Mapeando a resposta para retornar apenas a string
    );
  }

  register(userName: string, password: string, email: string): Observable<string> {
    const user = { userName, password, email };
    //const url = `https://prostudy-api.azurewebsites.net/auth/register/user`;
    const url = `http://localhost:8080/auth/register/user`;
    return this.http.post<any>(url, user).pipe(
      catchError(this.handleError), // Supondo que a resposta tenha uma mensagem
    );
  }

  private handleError(error: HttpErrorResponse) {
    let errorMessage = 'Ocorreu um erro desconhecido.';

    if (error.error instanceof ErrorEvent) {
      // Erro no cliente
      errorMessage = `Erro: ${error.error.message}`;
    } else {
      // Erro no servidor
      errorMessage = `Erro: ${error.status}, Mensagem: ${error.message}`;
    }

    console.error(errorMessage);
    return throwError(() => new Error(errorMessage));
  }

  userLoadInfo():Observable<UserFull>{
    return this.route.queryParams.pipe(
      switchMap(params => {
        const userName = params['u'];
        const url = `https://prostudy-api.azurewebsites.net/user/load/${userName}`;
        //const url = `http://localhost:8080/user/load/${userName}`;
        return this.http.get<UserFull>(url);
      })
    );
  }
}

