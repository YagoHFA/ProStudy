import { Component, Input, OnInit, input } from '@angular/core';
import { Video } from '../../class/video';
import { ActivatedRoute, Router } from '@angular/router';
import { VideoService } from '../../service/controller/video.service';

@Component({
  selector: 'app-video',
  templateUrl: './video.component.html',
  styleUrl: './video.component.css'
})
export class VideoComponent implements OnInit{

  constructor(){


  }
  ngOnInit(): void {

  }
  @Input() video:Video = new Video();
}
