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
    this.video.titulo = "BigsMacs";

    this.video2.id = "aAgbevbQH-s";
    this.video2.titulo = "ObservationDiaryes";
    this.videoList.push(this.video);
    this.videoList.push(this.video2);
  }
    category:Category = new Category();
    video:Video = new Video();
    video2:Video = new Video();
    videoList:Video[] = [];
}
