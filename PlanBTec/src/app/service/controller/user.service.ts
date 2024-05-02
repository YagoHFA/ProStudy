import { useAnimation } from '@angular/animations';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { error } from 'console';
import { catchError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http:HttpClient) { }

  login(userName:string , password:string){
    const user = {
      userName:userName,
      password:password
    }
    const url = `http://localhost:8080/auth/login`;
    this.http.post<string>(url, user)
    .pipe(
      catchError((error)=>{
        console.log('teste');
        return error;
      }))
    .subscribe(
      (data)=>{
        console.log(data);
      })


  }


}

