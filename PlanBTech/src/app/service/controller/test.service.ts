import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Category } from '../../class/category';

@Injectable({
  providedIn: 'root'
})
export class TestService {

  constructor(private http:HttpClient) {

  }

  categoryList(): Observable<Category[]> {
        const url = 'http://localhost:8080/category/test/allcategory';
        return this.http.get<Category[]>(url);
      }
    ;

}
