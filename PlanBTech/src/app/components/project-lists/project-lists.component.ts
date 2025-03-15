import { Component, Input, OnInit } from '@angular/core';
import { Projects } from '../../class/projects';
import { UserlocalstorageService } from '../../service/localstorage/userlocalstorage.service';
import { JwtService } from '../../service/controller/jwt.service';

@Component({
  selector: 'app-project-lists',
  templateUrl: './project-lists.component.html',
  styleUrl: './project-lists.component.css'
})
export class ProjectListsComponent {
  @Input() projects:Projects[] = [];
}
