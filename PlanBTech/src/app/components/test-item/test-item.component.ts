import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-test-item',
  templateUrl: './test-item.component.html',
  styleUrl: './test-item.component.css'
})
export class TestItemComponent {
  @Input() imageLink: string = '';
  @Input() title: string = '';
}
