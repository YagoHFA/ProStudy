import { Component, Input, OnInit, input } from '@angular/core';
import { Video } from '../../class/video';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-video',
  templateUrl: './video.component.html',
  styleUrl: './video.component.css'
})
export class VideoComponent implements OnInit{

  constructor(private route: ActivatedRoute,
              private router: Router){


  }
  ngOnInit(): void {
      this.router.navigate.toString
  }
  @Input() video:Video = new Video();
}
