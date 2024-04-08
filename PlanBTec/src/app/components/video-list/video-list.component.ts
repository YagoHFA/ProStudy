import { Component, Input, OnInit } from '@angular/core';
import { Category } from '../../class/category';
import { Video } from '../../class/video';
import { NgOptimizedImage } from '@angular/common'

@Component({
  selector: 'app-video-list',
  templateUrl: './video-list.component.html',
  styleUrl: './video-list.component.css'
})
export class VideoListComponent implements OnInit{
  ngOnInit(): void {
  }
    @Input() videoList:Video[] = [];
}
