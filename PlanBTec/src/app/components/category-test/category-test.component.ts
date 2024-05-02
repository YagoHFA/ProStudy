import { Component } from '@angular/core';
import { Category } from '../../class/category';

@Component({
  selector: 'app-category-test',
  templateUrl: './category-test.component.html',
  styleUrl: './category-test.component.css'
})
export class CategoryTestComponent {

  categoryTest:Category[] = [];
}
