import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { UserlocalstorageService } from '../localstorage/userlocalstorage.service';
import { catchError } from 'rxjs';
import { enviroment } from '../../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ProjectService {

  constructor(private http:HttpClient,private userStorage:UserlocalstorageService) { }
  //Creates api url with enviroments mode
  apiUrl:string = enviroment.apiUrl;
  createProject(projectName:string, shortDescription:string,projectURL:string){


    //Take logged user to make action
    let projectOwner = this.userStorage.getUserName()

    //Populate object project that gona be crate
    const project = {projectOwner,projectName, shortDescription, projectURL}

    //Headers for token authorization
    const headers = new HttpHeaders().set('Authorization', `Bearer ${this.userStorage.getToken()}`);
    //Url for API
    const url = `${this.apiUrl}/user/project/add`

    //Create a new project with logged user has owner
    this.http.put<any>(url,project,{headers}).pipe(
      catchError(error => {
        console.error('Erro ao criar projeto',error);
        return error;
      }
      )
    ).subscribe(
      data => {
        console.log("Sucesso" + data);
      }
    );
  }
}
