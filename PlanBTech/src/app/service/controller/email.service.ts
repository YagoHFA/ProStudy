import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class EmailService {

  constructor(private http:HttpClient) { }

  sendPasswordResetEmail(email:string){
    return this.http.post('/api/sendPasswordResetEmail',{email}).subscribe(
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
