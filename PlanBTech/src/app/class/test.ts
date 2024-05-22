import { Question } from "./question";

export class Test {
    testId:String;
    testTitle:String;
    testShortDescription:String;
    testLongDescription:String;
    questionsList:Question[];
    badgeURL:string
    questionNumber:number

    constructor(){
        this.testId     = '';
        this.testTitle  = '';
        this.questionsList  = [];
        this.testShortDescription = '';
        this.testLongDescription = '';
        this.badgeURL = ''
        this.questionNumber = 0
      }
}
