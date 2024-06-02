import { Projects } from "../projects";
import { Role } from "./role";
import { TestBadge } from "./test-badge";

export class UserFull {
  userName:string = '';
  email:string = '';
  roles:Role[] = [];
  skillTests:TestBadge[] = []
  projects:Projects[] = []
}
