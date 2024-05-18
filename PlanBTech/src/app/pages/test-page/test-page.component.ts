import { Component, Input, OnInit } from '@angular/core';
import { TestService } from '../../service/controller/test.service';
import { Test } from '../../class/test';

@Component({
  selector: 'app-test-page',
  templateUrl: './test-page.component.html',
  styleUrl: './test-page.component.css'
})
export class TestPageComponent implements OnInit{
constructor(private testService:TestService){}
  ngOnInit(): void {
    this.testService.getTesteById().subscribe(
      (test:Test)=>{
        this.test = test;
      }
    );
  }
  @Input() test: Test = new Test();
}
