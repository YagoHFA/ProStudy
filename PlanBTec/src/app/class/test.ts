import { Question } from "./question";

export class Test {
    testId:number;
    testTitle:String;
    testShortDescription:String;
    testLongDescription:String;
    questions:Question[];


    constructor(){
        this.testId     = 0;
        this.testTitle  = '';
        this.questions  = [];
        this.testShortDescription = '';
        this.testLongDescription = '';
      }
}
