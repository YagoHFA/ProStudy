import { Component, Input, OnInit, QueryList, ViewChildren } from '@angular/core';
import { TestService } from '../../service/controller/test.service';
import { Test } from '../../class/test';
import { QuestionComponent } from '../../components/question/question.component';
import { MatDialog } from '@angular/material/dialog';
import { MessageModalComponent } from '../../modals/message-modal/message-modal.component';
import { title } from 'node:process';
import { TestFailedComponent } from '../../modals/test-failed/test-failed.component';

@Component({
  selector: 'app-test-page',
  templateUrl: './test-page.component.html',
  styleUrl: './test-page.component.css'
})
export class TestPageComponent implements OnInit{

  finish:boolean = false;

  @ViewChildren('childComponents') childComponents!: QueryList<QuestionComponent>;

  constructor(private testService:TestService, public dialog:MatDialog){}

  ngOnInit(): void {
    this.testService.getTesteById().subscribe(
      (test:Test)=>{
        this.test = test;
        this.maxQuestion = this.test.questionsList.length
      }
    );
  }
  test: Test = new Test();
  points:number[] = []
  index:number = 0;
  maxQuestion:number = 0;

  nextQuestion(){
    const selectedAnswers = this.childComponents.map(child => child.getSelectedAnswer());
    if (this.index < this.maxQuestion-1 && selectedAnswers[0] > 0){
    this.index++

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

    if(sum >= Math.floor((this.maxQuestion * 5)* 0.75)){
      this.openDialog()
    }
    else{
      this.openFailedDialog()
    }
  }

  openDialog(): void {
    const dialogRef = this.dialog.open(MessageModalComponent, {
      data: {message:'Parabéns você passou no Teste',
      icon:this.test.badgeURL,
      button: 'Pegar Certificação',
      title: this.test.testTitle,
      testId: this.test.testId
    }
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
    });
  }

  openFailedDialog(): void {
    const dialogRef = this.dialog.open(TestFailedComponent, {
      data: { url: this.test.badgeURL }
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
    });
  }
}
