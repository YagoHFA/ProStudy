import { Question } from "./question";

export class Test {
    testId:String;
    testTitle:String;
    testShortDescription:String;
    testLongDescription:String;
    questions:Question[];
    badgeURL:string
    questionNumber:number

    constructor(){
        this.testId     = '';
        this.testTitle  = '';
        this.questions  = [];
        this.testShortDescription = '';
        this.testLongDescription = '';
        this.badgeURL = ''
        this.questionNumber = 0
      }
}
