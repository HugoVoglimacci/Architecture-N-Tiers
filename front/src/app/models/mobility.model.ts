import {Student} from './student.model';

export class Mobility {

  public id: number;
  public country: string;
  public city: string;
  public startDate: string;
  public endDate: string;
  public student: Student;


  constructor(id: number, country: string, city: string, startDate: string, endDate: string, student: Student) {
    this.id = id;
    this.country = country;
    this.city = city;
    this.startDate = startDate;
    this.endDate = endDate;
    this.student = student;
  }
}
