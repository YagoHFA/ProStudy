import { Component, OnInit } from '@angular/core';
import { Category } from '../../class/category';
import { HomepageConfigService } from '../../service/controller/homepageconfig.service';

@Component({
  selector: 'app-category-list',
  templateUrl: './category-list.component.html',
  styleUrl: './category-list.component.css'
})
export class CategoryListComponent implements OnInit{

  categoryVideo:Category[] = [];
  isLoading:boolean = true;

  ngOnInit(): void {
    this.isLoading = true;
    this.homePageConf.categoryList().subscribe(
      (categoryList:Category[]) =>{
        this.categoryVideo = categoryList
        this.isLoading = false;
      }
    )
  }

  constructor(private homePageConf:HomepageConfigService){

  }
}
