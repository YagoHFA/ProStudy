import { Component, Input, OnInit, input } from '@angular/core';
import { Video } from '../../class/video';
import { SafeResourceUrl, DomSanitizer } from '@angular/platform-browser';

@Component({
  selector: 'app-video',
  templateUrl: './video.component.html',
  styleUrl: './video.component.css'
})
export class VideoComponent implements OnInit{

getVideoURL(videoId: string):SafeResourceUrl  {
  const videoUrl = `https://www.youtube.com/embed/${videoId}`;
  return this.sanitizer.bypassSecurityTrustResourceUrl(videoUrl);
}

  constructor(private sanitizer:DomSanitizer){


  }
  ngOnInit(): void {

  }
  @Input() video:Video = new Video();
}
