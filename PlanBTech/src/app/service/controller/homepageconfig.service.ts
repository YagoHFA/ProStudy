import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Category } from '../../class/category';
import { Observable } from 'rxjs';
import { enviroment } from '../../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class HomepageConfigService {

  apiUrl:string = enviroment.apiUrl;
  constructor(private http:HttpClient) {

  }

  categoryList(): Observable<Category[]> {

        const url = `${this.apiUrl}category/video/allcategory`;

        return this.http.get<Category[]>(url);
      }
    ;

}
