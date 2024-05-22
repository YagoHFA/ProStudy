import { Answer } from "./answer";
import { Test } from "./test";

export class Question {

    questionId:Number;
    questionText:String;
    testeId:Test;
    anwersList:Answer[];

    constructor(){
        this.questionId     = 0;
        this.questionText   = '';
        this.testeId        = new Test();
        this.anwersList        = [];
      }
}
