import { Component, ElementRef, Input, OnInit, ViewChild } from '@angular/core';
import { Test } from '../../class/test';

@Component({
  selector: 'app-test-list',
  templateUrl: './test-list.component.html',
  styleUrl: './test-list.component.css'
})
export class TestListComponent implements OnInit {
  @Input() testList: Test[] = [];
  @ViewChild('testCarousel', { static: true }) testCarousel!: ElementRef;

  currentIndex: number = 0;
  maxVisibleItems: number = 4; // Defina o número máximo de itens visíveis aqui

  ngOnInit(): void {

    this.updateCarousel();
  }
  nextSlide(): void {
    const containerWidth = this.testCarousel.nativeElement.offsetWidth;
    const numTests = this.testList.length;
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
}
