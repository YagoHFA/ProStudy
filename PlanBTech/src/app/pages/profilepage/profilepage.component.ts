import { Component, OnInit } from '@angular/core';
import { UserService } from '../../service/controller/user.service';
import { UserFull } from '../../class/model/user-full';
import { JwtService } from '../../service/controller/jwt.service';
import { UserlocalstorageService } from '../../service/localstorage/userlocalstorage.service';
import { MatDialog } from '@angular/material/dialog';
import { AddProjectComponent } from '../../modals/add-project/add-project.component';

@Component({
  selector: 'app-profilepage',
  templateUrl: './profilepage.component.html',
  styleUrl: './profilepage.component.css'
})
export class ProfilepageComponent implements OnInit{

  constructor(private userService:UserService,
              private jwt:JwtService,
              private userLocalStorage:UserlocalstorageService,
              public dialogRef:MatDialog){}
  permission:boolean = false;
  ngOnInit(): void {
   this.load();
  }
  project:boolean = false;
  userName:string = ''

  user:UserFull = new UserFull();
  chageStatus(state:boolean ){
    this.project = state;
  }

  addProject(){
    const dialogRef = this.dialogRef.open(AddProjectComponent);
    dialogRef.afterClosed().subscribe(result => {
      console.log(`Dialog result: ${result}`);
      this.load();
    });
  }

  load(){
    this.userService.userLoadInfo()
   .subscribe((response:UserFull) =>{
    this.user = response;
    this.userName = this.userLocalStorage.getUserName()
   if(this.user.userName == this.userName){
    this.permission = true;
   }
   });

  }
}
