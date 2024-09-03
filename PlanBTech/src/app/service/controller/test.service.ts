import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, Observable, switchMap } from 'rxjs';
import { Category } from '../../class/category';
import { Test } from '../../class/test';
import { ActivatedRoute } from '@angular/router';
import { UserlocalstorageService } from '../localstorage/userlocalstorage.service';
import { JwtService } from './jwt.service';

@Injectable({
  providedIn: 'root'
})
export class TestService {

  constructor(private http:HttpClient,
    private route:ActivatedRoute,
    private userStorage:UserlocalstorageService,
    private jwt:JwtService) {

  }

  categoryList(): Observable<Category[]> {
        const url = 'https://prostudy-api.azurewebsites.net/category/test/allcategory';
        //const url = 'http://localhost:8080/category/test/allcategory';
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
        })
      );
    }

    concluirTest(testId: string) {
      // Extrair informações do token
      const token = this.userStorage.getToken();
      const userInfo = this.jwt.parseJwt(token);
      const userName:string = userInfo.sub
      // Criar o payload da requisição
      const payload = {
        testId,
        userName
      };
      const url = `https://prostudy-api.azurewebsites.net/user/test/complete`
      //const url = `http://localhost:8080/user/test/complete`;
      const headers = new HttpHeaders().set('Authorization', `Bearer ${token}`);

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
}
