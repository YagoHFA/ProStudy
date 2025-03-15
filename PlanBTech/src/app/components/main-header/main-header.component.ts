import { Component, OnInit } from '@angular/core';
import { JwtService } from '../../service/controller/jwt.service';
import { UserlocalstorageService } from '../../service/localstorage/userlocalstorage.service';

@Component({
  selector: 'app-main-header',
  templateUrl: './main-header.component.html',
  styleUrl: './main-header.component.css'
})
export class MainHeaderComponent{
  constructor(private userLocalStorage:UserlocalstorageService){}

  userName:string = this.userLocalStorage.getUserName();
}
