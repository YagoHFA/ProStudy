import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Category } from '../../class/category';

@Injectable({
  providedIn: 'root'
})
export class HomepageConfigService {

  constructor(private http:HttpClient) {

  }
  getAllCategory(): Category[]{
    const categoryList:Category[] = [];
    const url = 'http://localhost:8080/category/allcategory';

    this.http.get<Category[]>(url).subscribe(
      (Response:Category[]) => {
        categoryList.push(...Response)



      }
    );
    return categoryList;
  }
}
