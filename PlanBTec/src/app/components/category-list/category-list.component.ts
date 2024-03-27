import { Component, OnInit } from '@angular/core';
import { Category } from '../../class/category';
import { Video } from '../../class/video';
import { HomepageConfigService } from '../../service/controller/homepageconfig.service';

@Component({
  selector: 'app-category-list',
  templateUrl: './category-list.component.html',
  styleUrl: './category-list.component.css'
})
export class CategoryListComponent implements OnInit{
  ngOnInit(): void {
    this.categoryTest = this.homePageConf.getAllCategory();
  }

  constructor(private homePageConf:HomepageConfigService){

  }

  categoryTest:Category[] = [];
}
