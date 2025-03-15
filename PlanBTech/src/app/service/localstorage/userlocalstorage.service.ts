import { Inject, Injectable, PLATFORM_ID } from '@angular/core';
import { isPlatformBrowser } from '@angular/common';

@Injectable({
  providedIn: 'root'
})
export class UserlocalstorageService {



  constructor(@Inject(PLATFORM_ID) private plataformId: object) {

   }

   setToken(token:string){
    if(isPlatformBrowser(this.plataformId)){
      localStorage.setItem('token',token)
    }
   }

   getToken():string{
    if(isPlatformBrowser(this.plataformId)){
      const token =  localStorage.getItem('token')
      return token ? token : '';
    }
    return '';
   }

   setUserName(userName:string){
    if(isPlatformBrowser(this.plataformId)){
      localStorage.setItem('userName', userName)
    }
   }

   getUserName():string{
    if(isPlatformBrowser(this.plataformId)){
      const userName =  localStorage.getItem('userName')
      return userName ? userName : '';
    }
    return '';
   }
}
