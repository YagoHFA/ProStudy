import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { UserlocalstorageService } from '../localstorage/userlocalstorage.service';
import { error } from 'console';
import { catchError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProjectService {

  constructor(private http:HttpClient,private userStorage:UserlocalstorageService) { }

  createProject(projectName:string, shortDescription:string,projectURL:string){
    const headers = new HttpHeaders().set('Authorization', `Bearer ${this.userStorage.getToken()}`);
    const url = `http://localhost:8080/user/project/add`
    let projectOwner = this.userStorage.getUserName()
    const project = {projectOwner,projectName, shortDescription, projectURL}
    this.http.post<any>(url,project,{headers}).pipe(
      catchError(error => {
        console.error('Erro ao criar projeto',error);
        return error;
      }
      )
    )
  }
}
