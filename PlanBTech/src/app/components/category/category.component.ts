import { Component, Input, OnInit } from '@angular/core';
import { Category } from '../../class/category';

@Component({
  selector: 'app-category',
  templateUrl: './category.component.html',
  styleUrl: './category.component.css'
})
export class CategoryComponent implements OnInit{
  ngOnInit(): void {

  }
  @Input() category:Category = new Category();
}
