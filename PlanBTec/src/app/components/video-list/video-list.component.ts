import { Component, Input, OnInit, ElementRef, ViewChild } from '@angular/core';
import { Video } from '../../class/video';

@Component({
  selector: 'app-video-list',
  templateUrl: './video-list.component.html',
  styleUrls: ['./video-list.component.css']
})
export class VideoListComponent implements OnInit {
  @Input() videoList: Video[] = [];
  @ViewChild('videoCarousel', { static: true }) videoCarousel!: ElementRef;

  currentIndex: number = 0;
  maxVisibleItems: number = 3; // Defina o número máximo de itens visíveis aqui

  ngOnInit(): void {
    this.updateCarousel();
  }
  nextSlide(): void {
    const containerWidth = this.videoCarousel.nativeElement.offsetWidth;
    const numVideos = this.videoList.length;
    const maxIndex = Math.ceil(numVideos / this.maxVisibleItems) - 1;

    if (this.currentIndex < maxIndex) {
      this.currentIndex++;
      this.updateCarousel();
    }
  }

  prevSlide(): void {
    if (this.currentIndex > 0) {
      this.currentIndex--;
      this.updateCarousel();
    }
  }

  updateCarousel(): void {
    const containerWidth = this.videoCarousel.nativeElement.offsetWidth;
    this.videoCarousel.nativeElement.querySelector('.videoList').style.transform = `translateX(-${this.currentIndex * containerWidth}px)`;
  }
}
