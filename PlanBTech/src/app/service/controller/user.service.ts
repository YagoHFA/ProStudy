import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { catchError, Observable, throwError, map, switchMap } from 'rxjs';
import { UserFull } from '../../class/model/user-full';
import { enviroment } from '../../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  apiUrl:string = enviroment.apiUrl;
  constructor(private http:HttpClient,
              private route:ActivatedRoute
  ) { }

  login(userName: string, password: string): Observable<string> {
    const user = { userName, password }; // Usando shorthand property notation
    const url = `${this.apiUrl}/auth/login`;
    return this.http.post<any>(url, user).pipe(
      catchError((error: HttpErrorResponse) => {
        let errorMessage = 'Ocorreu um erro desconhecido.';

        if (error.error instanceof ErrorEvent) {
          errorMessage = `Erro: ${error.error.message}`;
        } else {
          errorMessage = `Erro: ${error.status}, Mensagem: ${error.message}`;
        }
        return throwError(() => new Error(errorMessage));
      }),

      map((token: any) => token.token)
    );
  }

  register(userName: string, password: string, email: string): Observable<string> {
    const user = { userName, password, email };
    const url = `${this.apiUrl}/auth/register/user`;
    return this.http.post<any>(url, user).pipe(
      catchError(this.handleError), // Supondo que a resposta tenha uma mensagem
    );
  }

  private handleError(error: HttpErrorResponse) {
    let errorMessage = 'Ocorreu um erro desconhecido.';

    if (error.error instanceof ErrorEvent) {
      errorMessage = `Erro: ${error.error.message}`;
    } else {
      errorMessage = `Erro: ${error.status}, Mensagem: ${error.message}`;
    }

    console.error(errorMessage);
    return throwError(() => new Error(errorMessage));
  }

  userLoadInfo():Observable<UserFull>{
    return this.route.queryParams.pipe(
      switchMap(params => {
        const userName = params['u'];
        const url = `${this.apiUrl}/user/load/${userName}`;
        return this.http.get<UserFull>(url);
      })
    );
  }
}
