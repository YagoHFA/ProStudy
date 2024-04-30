import { Component, Input, OnInit } from '@angular/core';
import { Test } from '../../class/test';

@Component({
  selector: 'app-test',
  templateUrl: './test.component.html',
  styleUrl: './test.component.css'
})

export class TestComponent implements OnInit{

  constructor(){}
  ngOnInit(): void {

  }
  @Input() test:Test = new Test();
}
