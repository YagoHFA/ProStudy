import { Component, Input, OnInit } from '@angular/core';
import { Test } from '../../class/test';

@Component({
  selector: 'app-test-show',
  templateUrl: './test-show.component.html',
  styleUrl: './test-show.component.css'
})
export class TestShowComponent implements OnInit {
  ngOnInit(): void {

  }
  @Input() test: Test = new Test();

}
