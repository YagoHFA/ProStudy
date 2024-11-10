import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, Observable, switchMap } from 'rxjs';
import { Category } from '../../class/category';
import { Test } from '../../class/test';
import { ActivatedRoute } from '@angular/router';
import { UserlocalstorageService } from '../localstorage/userlocalstorage.service';
import { JwtService } from './jwt.service';
import { enviroment } from '../../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class TestService {

  apiUrl:string = enviroment.apiUrl;
  constructor(private http:HttpClient,
    private route:ActivatedRoute,
    private userStorage:UserlocalstorageService,
    private jwt:JwtService) {

  }

  categoryList(): Observable<Category[]> {
        const url = `${this.apiUrl}/category/test/allcategory`;
        return this.http.get<Category[]>(url);
      }
    ;
    getTesteById(): Observable<Test> {

      const headers = new HttpHeaders().set('Authorization', `Bearer ${this.userStorage.getToken()}`);
      return this.route.queryParams.pipe(
        switchMap(params => {
          const testId = params['t'];
          if(testId != undefined){}
          const url = `${this.apiUrl}/test/find/${testId}`;
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
      const url = `${this.apiUrl}/user/test/complete`
      const headers = new HttpHeaders().set('Authorization', `Bearer ${token}`);

       this.http.put<any>(url, payload, { headers }).pipe(

        catchError(error => {
          console.error('Erro ao concluir teste:', error);
          return error(error);
        })
      ).subscribe(
        response => {
          // Lógica de sucesso
          console.log('Teste concluído com sucesso:', response);
        },
        error => {
          // Lógica de erro
          console.error('Erro ao concluir teste:', error);
        }
      );
    }
}
