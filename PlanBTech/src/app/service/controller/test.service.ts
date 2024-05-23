import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, Observable, switchMap } from 'rxjs';
import { Category } from '../../class/category';
import { Test } from '../../class/test';
import { ActivatedRoute } from '@angular/router';
import { UserlocalstorageService } from '../localstorage/userlocalstorage.service';
import { error } from 'console';

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
          //const url = `https://prostudy-api.azurewebsites.net/test/find/${testId}`;
          const url = `http://localhost:8080/test/find/${testId}`;
          return this.http.get<Test>(url, {headers});
        }),catchError((error) => {
          console.error('erro'+ error);
          throw new Error('Error retrieving test');
        })
      );
    }
}
