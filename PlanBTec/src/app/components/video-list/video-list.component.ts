import { Component, OnInit } from '@angular/core';
import { Category } from '../../class/category';
import { Video } from '../../class/video';

@Component({
  selector: 'app-video-list',
  templateUrl: './video-list.component.html',
  styleUrl: './video-list.component.css'
})
export class VideoListComponent implements OnInit{
  ngOnInit(): void {
    this.video.id = "Z6jZUXpsqvc";
    this.video.titulo = "teste";
  }
    category:Category = new Category();
    video:Video = new Video();
}
