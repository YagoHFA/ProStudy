import { Component, Input, ViewChild } from '@angular/core';
import { Question } from '../../class/question';
import { NgForm } from '@angular/forms';
import test from 'node:test';

@Component({
  selector: 'app-question',
  templateUrl: './question.component.html',
  styleUrl: './question.component.css'
})
export class QuestionComponent {
  @Input() question: Question = new Question();
  selectedAnswer: number = 0;

  getSelectedAnswer(): number {
    const answer = this.selectedAnswer
    console.log(answer)
    this.resetSelection()
    return answer ;
  }

  resetSelection() {
    this.selectedAnswer = 0;
  }

  changeSelection(answer: number) {
    this.selectedAnswer = answer + 1;
  }
}
