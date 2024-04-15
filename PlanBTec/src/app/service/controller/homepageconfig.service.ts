import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Category } from '../../class/category';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class HomepageConfigService {

  constructor(private http:HttpClient) {

  }

  categoryList(): Observable<Category[]> {

        const url = 'http://localhost:8080/category/allcategory';
        this.http.get<Category[]>(url).subscribe(x => x.forEach((y) =>{
          console.log(y.categoryName)
          console.log(y.videoList)
          y.videoList.forEach(z => console.log(z.videoTitle))
        }));
        return this.http.get<Category[]>(url);
      }
    ;

}
