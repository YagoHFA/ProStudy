import { Component, ElementRef, Input, OnInit, ViewChild, HostListener } from '@angular/core';
import { Test } from '../../class/test';

@Component({
  selector: 'app-test-list',
  templateUrl: './test-list.component.html',
  styleUrls: ['./test-list.component.css']
})
export class TestListComponent implements OnInit {
  @Input() testList: Test[] = [];
  filteredTestList: Test[] = [];
  @ViewChild('testCarousel', { static: true }) testCarousel!: ElementRef;

  currentIndex: number = 0;
  maxVisibleItems: number = 4;

  ngOnInit(): void {
    this.filterTests();
    this.updateMaxVisibleItems();
    this.updateCarousel();
  }

  @HostListener('window:resize', ['$event'])
  onResize(event: any): void {
    this.updateMaxVisibleItems();
    this.updateCarousel();
  }

  nextSlide(): void {
    const numTests = this.filteredTestList.length;
    const maxIndex = Math.ceil(numTests / this.maxVisibleItems) - 1;

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
    const containerWidth = this.testCarousel.nativeElement.offsetWidth;
    this.testCarousel.nativeElement.querySelector('.testList').style.transform = `translateX(-${this.currentIndex * containerWidth}px)`;
  }

  updateMaxVisibleItems(): void {
    const containerWidth = this.testCarousel.nativeElement.offsetWidth;

    if (containerWidth >= 1200) {
      this.maxVisibleItems = 4;
    } else if (containerWidth >= 992) {
      this.maxVisibleItems = 3;
    } else if (containerWidth >= 768) {
      this.maxVisibleItems = 2;
    } else {
      this.maxVisibleItems = 1;
    }
  }

  filterTests(): void {
    this.filteredTestList = this.testList.filter(test => test.questionNumber > 0);
  }

  isVisible(index: number): boolean {
    const start = this.currentIndex * this.maxVisibleItems;
    const end = start + this.maxVisibleItems;
    return index >= start && index < end;
  }
}
