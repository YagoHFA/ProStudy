import { Component, Input, OnInit, ElementRef, ViewChild, HostListener, AfterViewInit, AfterViewChecked } from '@angular/core';
import { Video } from '../../class/video';
import { VideolocalstorageService } from '../../service/localstorage/videolocalstorage.service';

@Component({
  selector: 'app-video-list',
  templateUrl: './video-list.component.html',
  styleUrls: ['./video-list.component.css']
})
export class VideoListComponent implements OnInit, AfterViewInit, AfterViewChecked {
  @Input() videoList: Video[] = [];
  @ViewChild('videoCarousel', { static: true }) videoCarousel!: ElementRef;

  currentIndex: number = 0;
  maxVisibleItems: number = 4; // Número inicial de itens visíveis
  viewInitialized: boolean = false;

  constructor(private videoLocalStorage: VideolocalstorageService) {}

  ngOnInit(): void {
    this.updateMaxVisibleItems();
  }

  ngAfterViewInit(): void {
    this.viewInitialized = true;
    this.updateCarousel();
  }

  ngAfterViewChecked(): void {
    if (this.viewInitialized && this.videoList.length > 0) {
      this.updateCarousel();
    }
  }

  @HostListener('window:resize', ['$event'])
  onResize(event: any): void {
    this.updateMaxVisibleItems();
    this.updateCarousel();
  }

  nextSlide(): void {
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
    if (this.videoList.length === 0 || !this.viewInitialized) {
      return;
    }
    const videoItems = this.videoCarousel.nativeElement.querySelectorAll('.video-item');
    const videoListElement = this.videoCarousel.nativeElement.querySelector('.videoList');
    if (videoItems.length > 0) {
      const itemWidth = videoItems[0].offsetWidth;
      const offset = this.currentIndex * itemWidth * this.maxVisibleItems;
      videoListElement.style.transform = `translateX(-${offset}px)`;
      videoItems.forEach((item: HTMLElement, index: number) => {
        if (this.isVisible(index)) {
          item.classList.add('visible');
        } else {
          item.classList.remove('visible');
        }
      });
    } else {
      console.warn('No .video-item elements found');
    }
  }

  updateMaxVisibleItems(): void {
    const containerWidth = this.videoCarousel.nativeElement.offsetWidth;

    if (containerWidth >= 1200) {
      this.maxVisibleItems = 4;
    } else if (containerWidth >= 992) {
      this.maxVisibleItems = 3;
    } else if (containerWidth >= 768) {
      this.maxVisibleItems = 2;
    } else {
      this.maxVisibleItems = 1;
    }

    this.currentIndex = 0; // Reset currentIndex on resize
  }

  addRecomendation(videoList: Video[]): void {
    this.videoLocalStorage.setRecomendation(videoList);
  }

  isVisible(index: number): boolean {
    const start = this.currentIndex * this.maxVisibleItems;
    const end = start + this.maxVisibleItems - 1;
    return index >= start && index <= end;
  }
}
