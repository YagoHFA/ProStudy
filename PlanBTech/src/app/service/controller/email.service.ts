import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { enviroment } from '../../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class EmailService {

  apiUrl:string = enviroment.apiUrl;
  constructor(private http:HttpClient) { }

  sendPasswordResetEmail(email:string){
    return this.http.post(`${this.apiUrl}/api/sendPasswordResetEmail`,{email}).subscribe(
      {
        next:data => {
          console.log('Email enviado',data);
        },
        error:err => {
          console.error('Erro ao enviar email',err);
        }
      }
    );
  }
}
