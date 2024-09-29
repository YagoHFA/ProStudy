import { Component, OnInit } from '@angular/core';
import { Category } from '../../class/category';
import { TestService } from '../../service/controller/test.service';

@Component({
  selector: 'app-category-test',
  templateUrl: './category-test.component.html',
  styleUrl: './category-test.component.css'
})
export class CategoryTestComponent implements OnInit{
  isLoading:boolean = true;
  categoryTest:Category[] = [];

  ngOnInit(): void {
    this.testConfig.categoryList().subscribe(
      (category:Category[]) => {
       for(let element of category){
        for(let test of element.skillTestList){
          if(test.questionNumber>0){
            this.categoryTest.push(element)
            break
          }
        }
       }
        this.isLoading = false;
      })
  }

  constructor(private testConfig:TestService) {

  }

}
