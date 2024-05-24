import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, Observable, switchMap } from 'rxjs';
import { Category } from '../../class/category';
import { Test } from '../../class/test';
import { ActivatedRoute } from '@angular/router';
import { UserlocalstorageService } from '../localstorage/userlocalstorage.service';
import { error } from 'console';
import { userInfo } from 'os';

@Injectable({
  providedIn: 'root'
})
export class TestService {

  constructor(private http:HttpClient,  private route:ActivatedRoute, private userStorage:UserlocalstorageService) {

  }

  categoryList(): Observable<Category[]> {

        const url = 'http://localhost:8080/category/test/allcategory';
        return this.http.get<Category[]>(url);
      }
    ;
    getTesteById(): Observable<Test> {

      const headers = new HttpHeaders().set('Authorization', `Bearer ${this.userStorage.getToken()}`);
      return this.route.queryParams.pipe(
        switchMap(params => {
          const testId = params['t'];
          if(testId != undefined){}
          //const url = `https://prostudy-api.azurewebsites.net/test/find/${testId}`;
          const url = `http://localhost:8080/test/find/${testId}`;
          return this.http.get<Test>(url, {headers});
        }),catchError((error) => {
          console.error('erro'+ error);
          throw new Error('Error retrieving test');
        })
      );
    }

    concluirTest(testId: string) {
      // Extrair informações do token
      const token = this.userStorage.getToken();
      const userInfo = this.parseJwt(token);
      const userName:string = userInfo.sub
      // Criar o payload da requisição
      const payload = {
        testId,
        userName
      };

      const url = `http://localhost:8080/user/test/complete`;
      const headers = new HttpHeaders().set('Authorization', `Bearer ${token}`);
      console.log(headers)
      console.log(payload)

      // Realizar a solicitação HTTP e adicionar tratamento de erros
       this.http.put<any>(url, payload, { headers }).pipe(

        catchError(error => {
          // Tratar o erro aqui
          console.error('Erro ao concluir teste:', error);
          return error(error); // Reenviar o erro para que o componente que chamou saiba sobre ele
        })
      ).subscribe(
        response => {
          // Lógica de sucesso
          console.log('Teste concluído com sucesso:', response);
        },
        error => {
          // Lógica de erro
          console.error('Erro ao concluir teste:', error);
        },
        () => {
          // Lógica de conclusão (opcional)
          console.log('Requisição completa.');
        }
      );
    }

    // Função para decodificar o JWT
    parseJwt(token: string) {
      const base64Url = token.split('.')[1];
      const base64 = base64Url.replace(/-/g, '+').replace(/_/g, '/');
      const jsonPayload = decodeURIComponent(atob(base64).split('').map(function(c) {
        return '%' + ('00' + c.charCodeAt(0).toString(16)).slice(-2);
      }).join(''));

      return JSON.parse(jsonPayload);
    }
}
