import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import { HttpClientModule } from '@angular/common/http';
import { NotFoundComponent } from './not-found/not-found.component';
import {FormsModule} from '@angular/forms';
import {MobilityFormComponent} from './mobility-form/mobility-form.component';
import {MobilityListComponent} from './mobility-list/mobility-list.component';
import {MobilityCardComponent} from './mobility-card/mobility-card.component';
import {MobilityService} from './api/mobility.service';
import {StudentService} from './api/student.service';
import {MapComponent} from './map/map.component';
import {AgmCoreModule} from '@agm/core';
import { Ng2SearchPipeModule } from 'ng2-search-filter';

@NgModule({
  declarations: [
    AppComponent,
    MobilityCardComponent,
    MobilityListComponent,
    MobilityFormComponent,
    NavbarComponent,
    NotFoundComponent,
    MapComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    AgmCoreModule.forRoot({
      apiKey: 'AIzaSyCpmoRa6FM_O_9decDpGqe5Trs12fJun4w'
    }),
    Ng2SearchPipeModule
  ],
  providers: [StudentService, MobilityService],
  bootstrap: [AppComponent]
})
export class AppModule { }
