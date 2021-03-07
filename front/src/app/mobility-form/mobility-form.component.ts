import { Component, OnInit } from '@angular/core';
import {Student} from '../models/student.model';
import {StudentService} from '../api/student.service';
import {Router} from '@angular/router';
import {Mobility} from '../models/mobility.model';
import {MobilityService} from '../api/mobility.service';
import {DatePipe} from '@angular/common';

@Component({
  selector: 'app-mobility-form',
  templateUrl: './mobility-form.component.html',
  styleUrls: ['./mobility-form.component.scss']
})
export class MobilityFormComponent implements OnInit {

  public newStudent: Student = new Student('', '', '');
  public newMobility: Mobility = new Mobility(null, '', '', '', '', this.newStudent);

  public submited = false;

  constructor(private studentService: StudentService, private mobilityService: MobilityService,
              private router: Router) { }

  ngOnInit(): void {
  }

  public saveStudent(): void {

    const datePipe = new DatePipe('en-US');
    this.newMobility.startDate = datePipe.transform(this.newMobility.startDate, 'yyyy-MM-dd');
    this.newMobility.endDate = datePipe.transform(this.newMobility.endDate, 'yyyy-MM-dd');


    let startdate = this.newMobility.startDate;
    let endDate = this.newMobility.endDate;

    let varStartDate = new Date(startdate);
    let varEndDate = new Date(endDate);

    if (varStartDate > varEndDate) {
      alert('End date must be greater than Start Date');
    }
    else{

      this.mobilityService.postAddMobility(this.newMobility).subscribe(() => {
        this.router.navigate(['mobility-list']);
      });
      this.submited = true;
    }
  }

}
