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

  finish:boolean = false;

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
  points:number[] = []
  index:number = 0;
  maxQuestion:number = 0;

  nextQuestion(){
    const selectedAnswers = this.childComponents.map(child => child.getSelectedAnswer());
    if (this.index < this.maxQuestion-1 && selectedAnswers[0] > 0){
    this.index++
    console.log('Selected answers:', selectedAnswers[0]);
    this.points[this.index] = selectedAnswers[0]
    if(this.index == this.maxQuestion-1){

      this.finish = true
    }

  }

  }
  prevQuestion(){
    if (this.index > 0){
      this.index--
    }
    if(this.index == this.maxQuestion-2){
      this.finish = false
    }
  }

  calcResult(){
    let sum = 0
    const selectedAnswers = this.childComponents.map(child => child.getSelectedAnswer());
    this.points[this.index+1] = selectedAnswers[0]
    this.points.forEach(element => {
      sum += ( element-1 )
    });

  }
}
