import { Component, Input } from '@angular/core';
import { TestBadge } from '../../class/model/test-badge';

@Component({
  selector: 'app-test-card-list',
  templateUrl: './test-card-list.component.html',
  styleUrl: './test-card-list.component.css'
})
export class TestCardListComponent {
  @Input() tests:TestBadge[] = [];
}
