import {Component, Input, OnInit} from '@angular/core';
import {Mobility} from '../models/mobility.model';
import {MobilityService} from '../api/mobility.service';

@Component({
  selector: 'app-mobility-card',
  templateUrl: './mobility-card.component.html',
  styleUrls: ['./mobility-card.component.scss'],
})
export class MobilityCardComponent implements OnInit {

  @Input()
  public mobilityInput: Mobility;

  constructor(private mobilityService: MobilityService) { }

  ngOnInit() {}

  deleteMobility(): void {

    this.mobilityService.deleteMobility(this.mobilityInput.id).subscribe( );
    window.location.reload();
  }

}
