import { Component, OnInit } from '@angular/core';
import { Category } from '../../class/category';
import { Video } from '../../class/video';

@Component({
  selector: 'app-category-list',
  templateUrl: './category-list.component.html',
  styleUrl: './category-list.component.css'
})
export class CategoryListComponent implements OnInit{
  ngOnInit(): void {
    this.video.id = "JGv1vfk4Q_U";
    this.video.titulo = "Video1";

    this.video2.id = "4bzr06k4P5E";
    this.video2.titulo = "Video2";

    this.category.name = "Desenvolvimento Web";
    this.categoryList.push(this.category);

    this.category2.name = "Python";
    this.categoryList.push(this.category2);

    this.category.video.push(this.video);
    this.category.video.push(this.video2);

    this.category2.video.push(this.video);
    this.category2.video.push(this.video2);
  }
  category:Category = new Category();
  category2:Category = new Category();
  categoryList:Category[] = []; 
  video:Video = new Video();
  video2:Video = new Video();
}
