import { Component, OnInit } from '@angular/core';
import {Mobility} from '../models/mobility.model';
import {MobilityService} from '../api/mobility.service';

@Component({
  selector: 'app-map',
  templateUrl: './map.component.html',
  styleUrls: ['./map.component.scss'],
})
export class MapComponent implements OnInit {

  public mobilities: Mobility [];
  public markers: CustomMarker [];

  constructor(private mobilityService: MobilityService) { }

  ngOnInit(): void {
    this.markers = [];
    this.mobilityService.getMobilityList().subscribe((response: Mobility[]) => {
      this.mobilities = response;
      console.log('Réponse du serveur : ', response);
      this.mobilities.forEach( (mobility) => {
        this.geolocate(mobility);
      });
    });
    console.log(this.markers);
  }

geolocate = async (mobility: Mobility) => {

    let x: number;
    let y: number;
    let data;

    try {
      const res = await fetch('https://api.opencagedata.com/geocode/v1/json?q=' + mobility.city + ',' + mobility.country + '&key=b7b886ade2534b9b8756c7b99ceb4725');
      data = await res.json();

      x = data['results']['0']["geometry"]["lat"];
      y = data['results']['0']["geometry"]["lng"];
    }
    catch (e) {
      console.log(e);
    }

    const marker: CustomMarker = { latitude: x, longitude: y, studentName: (mobility.student.firstname + ' ' + mobility.student.lastname) };
    this.markers.push(marker);
  }
}

interface CustomMarker {
  latitude: number;
  longitude: number;
  studentName: string;
}
