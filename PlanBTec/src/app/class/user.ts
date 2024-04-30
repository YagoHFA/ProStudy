import { Projects } from "./projects";
import { Test } from "./test";

export class User {
  
  id: number;
  userName: string;
  userEmail: string;
  userPassword: string;
  projects:Projects[];
  testRealized:Test[];

  constructor(){
    this.id           = 0;
    this.userName     = '';
    this.userEmail    = '';
    this.userPassword = '';
    this.projects     = [];
    this.testRealized = [];
  }
}
