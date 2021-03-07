import {Injectable} from '@angular/core';
import {catchError, map} from 'rxjs/operators';
import {Observable} from 'rxjs';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Mobility} from '../models/mobility.model';

@Injectable({
  providedIn: 'root'
})
export class MobilityService {

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
    })
  };

  constructor(
    public httpApi: HttpClient
  ) {
  }

  public getMobilityList(): Observable<Mobility[]> {
    return this.httpApi.get('http://localhost:8080/mobilities').pipe(
      map((response: any) => response)
    );
  }

  public getMobilityById(id: number): Observable<Mobility> {
    return this.httpApi.get(`http://localhost:8080/mobilities/${id}`).pipe(
      map((response: any) => response)
    );
  }

  public postAddMobility(mobility: Mobility): Observable<Mobility> {

    return this.httpApi.post<Mobility>('http://localhost:8080/mobilities', mobility)
      .pipe(
        map((response: any) => response),
        catchError(async (err) => console.log(err))
      );
  }

  public editMobility(mobility: Mobility, id: number): Observable<Mobility> {
    return this.httpApi.patch<Mobility>(`http://localhost:8080/mobilities/${id}`, mobility)
      .pipe(
        map((response: any) => response),
        catchError(async (err) => console.log(err))
      );
  }

  public deleteMobility(id: number): Observable<Mobility> {
    return this.httpApi.delete<Mobility>(`http://localhost:8080/mobilities/${id}`)
      .pipe(
        map((response: any) => response),
        catchError(async (err) => console.log(err))
      );
  }

}
