import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {MobilityFormComponent} from './mobility-form/mobility-form.component';
import {MobilityListComponent} from './mobility-list/mobility-list.component';
import {MapComponent} from './map/map.component';
import {NotFoundComponent} from './not-found/not-found.component';

const routes: Routes = [
  // Routes par défaut
  { path: 'mobility-list', component: MobilityListComponent, pathMatch: 'prefix'},
  { path: '', component: MobilityListComponent, pathMatch: 'prefix'},
  { path: 'mobility-form', component: MobilityFormComponent, pathMatch: 'prefix'},
  { path: 'map', component: MapComponent, pathMatch: 'prefix'},
  { path: 'not-found', component: NotFoundComponent, pathMatch: 'prefix'},
  { path: '**', redirectTo: 'not-found'},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {

}
