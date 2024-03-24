import { Component, Input, OnInit, input } from '@angular/core';
import { Video } from '../../class/video';

@Component({
  selector: 'app-video',
  templateUrl: './video.component.html',
  styleUrl: './video.component.css'
})
export class VideoComponent implements OnInit{
  ngOnInit(): void {

  }
  @Input() video:Video = new Video();
}
