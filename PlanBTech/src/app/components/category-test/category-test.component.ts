import { Component, OnInit } from '@angular/core';
import { Category } from '../../class/category';
import { TestService } from '../../service/controller/test.service';

@Component({
  selector: 'app-category-test',
  templateUrl: './category-test.component.html',
  styleUrl: './category-test.component.css'
})
export class CategoryTestComponent implements OnInit{

  ngOnInit(): void {
    this.testConfig.categoryList().subscribe(
      (category:Category[]) => {
        this.categoryTest = category;
      })
  }

  constructor(private testConfig:TestService) {

  }
  categoryTest:Category[] = [];
}
