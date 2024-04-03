import { Component, OnInit } from '@angular/core';
import { Category } from '../../class/category';
import { HomepageConfigService } from '../../service/controller/homepageconfig.service';

@Component({
  selector: 'app-category-list',
  templateUrl: './category-list.component.html',
  styleUrl: './category-list.component.css'
})
export class CategoryListComponent implements OnInit{
  ngOnInit(): void {
    this.homePageConf.getVideoById().subscribe(
      (categoryList:Category[]) =>{
        categoryList.forEach(x => {
          console.log(x.videoList)
        })
        this.categoryTest = categoryList
      }
    )
  }

  constructor(private homePageConf:HomepageConfigService){

  }

  categoryTest:Category[] = [];
}
