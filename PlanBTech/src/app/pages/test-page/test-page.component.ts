import { Component, Input, OnInit, QueryList, ViewChildren } from '@angular/core';
import { TestService } from '../../service/controller/test.service';
import { Test } from '../../class/test';
import { QuestionComponent } from '../../components/question/question.component';

@Component({
  selector: 'app-test-page',
  templateUrl: './test-page.component.html',
  styleUrl: './test-page.component.css'
})
export class TestPageComponent implements OnInit{
  @ViewChildren('childComponents') childComponents!: QueryList<QuestionComponent>;

  constructor(private testService:TestService){}

  ngOnInit(): void {
    this.testService.getTesteById().subscribe(
      (test:Test)=>{
        this.test = test;
        this.maxQuestion = this.test.questionsList.length
      }
    );
  }
  @Input() test: Test = new Test();
  index:number = 0;
  maxQuestion:number = 0;

  nextQuestion(){
    if (this.index < this.maxQuestion-1){
    this.index++
    const selectedAnswers = this.childComponents.map(child => child.getSelectedAnswer());
    console.log('Selected answers:', selectedAnswers);
  }

  }
  prevQuestion(){
    if (this.index > 0){
      this.index--
    }
  }
}
