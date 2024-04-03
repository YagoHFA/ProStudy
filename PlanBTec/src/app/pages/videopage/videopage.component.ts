import { AfterContentChecked, AfterViewInit, Component, DoCheck, Input, OnChanges, OnDestroy, OnInit, SimpleChanges } from '@angular/core';
import { Video } from '../../class/video';
import { ActivatedRoute } from '@angular/router';
import { VideoService } from '../../service/controller/video.service';

@Component({
  selector: 'app-videopage',
  templateUrl: './videopage.component.html',
  styleUrl: './videopage.component.css',
  providers:[VideoService]
})
export class VideopageComponent implements OnInit{

  ngOnInit(): void {
       this.videoService.getVideoById().subscribe(
        (video:Video)=>{
          this.video = video;
        }
       )
  }
  constructor(private route:ActivatedRoute, private videoService:VideoService){
    console.log('pas')
  }


    video:Video = new Video();
}
