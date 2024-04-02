import { Component, Input, OnInit } from '@angular/core';
import { Video } from '../../class/video';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-videopage',
  templateUrl: './videopage.component.html',
  styleUrl: './videopage.component.css'
})
export class VideopageComponent implements OnInit{

  constructor(private route:ActivatedRoute){}

  ngOnInit(): void {
    this.video.videoId= "ZeMErc0kOkQ";
    this.video.videoTitle = "POINT BLANK - RUSHANDO ADOIDADO DE P90"
    this.route.queryParams.subscribe(params => console.log(params['v']))
  }
    video:Video = new Video();
}
