import {Mark} from "./mark";

export class Student {
  id: number;
  firstName: string;
  lastName: string;
  birthDay: any;
  group: number;
  marks = Array<Mark>();
}
