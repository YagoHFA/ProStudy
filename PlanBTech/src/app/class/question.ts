import { Answer } from "./answer";
import { Test } from "./test";

export class Question {

    questionId:Number;
    questionText:String;
    anwersList:Answer[];

    constructor(){
        this.questionId     = 0;
        this.questionText   = '';
        this.anwersList        = [];
      }
}
