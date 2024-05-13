import { Test } from "./test";
import { Video } from "./video";

export class Category {
  categoryId:number = 0;
  categoryName:string = "";
  videoList:Video[] = [];
  skillTestList:Test[] = [];
}
