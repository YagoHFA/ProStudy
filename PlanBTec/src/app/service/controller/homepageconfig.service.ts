import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Category } from '../../class/category';

@Injectable({
  providedIn: 'root'
})
export class HomepageconfigService {

  constructor(private http:HttpClient) {

  }
  getAllCategory(): Category[]{
    const categoryList:Category[] = [];
    const url = 'http://localhost:8080/category/allcategory';

    this.http.get<Category[]>(url).subscribe(
      (Response:Category[]) => {
        categoryList.push(...Response)
        categoryList.forEach(x => console.log(x.id + ' - ' + x.name + '\n' +  x.video.forEach(y => console.log(y.id + ' - ' + y.titulo))))


      }
    );
    return categoryList;
  }
}
