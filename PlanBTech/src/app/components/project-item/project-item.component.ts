import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-project-item',
  templateUrl: './project-item.component.html',
  styleUrl: './project-item.component.css'
})
export class ProjectItemComponent {
  @Input() title: string = '';
  @Input() description: string = '';
  @Input() details: string = '';
  @Input() buttons: { label: string, link: string }[] = [];
  @Input() footer: string = '';
}
