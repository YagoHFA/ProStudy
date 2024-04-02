import { Component, Input, OnInit } from '@angular/core';
import { Video } from '../../class/video';

@Component({
  selector: 'app-videopage',
  templateUrl: './videopage.component.html',
  styleUrl: './videopage.component.css'
})
export class VideopageComponent implements OnInit{
  ngOnInit(): void {
    this.video.videoId= "ZeMErc0kOkQ";
    this.video.videoTitle = "POINT BLANK - RUSHANDO ADOIDADO DE P90"
  }
    video:Video = new Video();
    @Input() set id(videoId:string){
      this.video.videoId = videoId;
    }
}
