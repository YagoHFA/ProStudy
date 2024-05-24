import { Component } from '@angular/core';

@Component({
  selector: 'app-profilepage',
  templateUrl: './profilepage.component.html',
  styleUrl: './profilepage.component.css'
})
export class ProfilepageComponent {
  project:boolean = false;

  chageStatus(){
    this.project = !this.project;
  }
}
