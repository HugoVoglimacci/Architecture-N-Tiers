import { Component, OnInit } from '@angular/core';
import {Mobility} from '../models/mobility.model';
import {MobilityService} from '../api/mobility.service';
import {DatePipe} from '@angular/common';

@Component({
  selector: 'app-mobility-list',
  templateUrl: './mobility-list.component.html',
  styleUrls: ['./mobility-list.component.scss'],
})
export class MobilityListComponent implements OnInit {

  term: string;
  public mobilities: Mobility [];

  constructor(private mobilityService: MobilityService) {
  }

  ngOnInit(): void {
    this.mobilityService.getMobilityList().subscribe((response: Mobility[]) => {
      this.mobilities = response;
      console.log('Réponse du serveur : ', response);

      const datePipe = new DatePipe('en-US');

      this.mobilities.forEach( (mobility) => {
        mobility.startDate = datePipe.transform(mobility.startDate, 'dd/MM/yyyy');
        mobility.endDate = datePipe.transform(mobility.endDate, 'dd/MM/yyyy');
    });
    });
  }

}
