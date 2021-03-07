import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable, of} from 'rxjs';
import {catchError, map} from 'rxjs/operators';
import {Student} from '../models/student.model';
import {Router} from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class StudentService {

  constructor(
    public httpApi: HttpClient,
    public router: Router
  ) {
  }

  getStudentList(): Observable<Student[]> {
    return this.httpApi.get('http://localhost:8080/students').pipe(
      map((response: any) => response)
    );
  }


  getStudentDetail(id: number): Observable<Student> {
    return this.httpApi.get(`http://localhost:8080/students/${id}`).pipe(
      map((response: any) => response)
    );
  }

  public postAddStudent(student: Student): Observable<Student> {
    return this.httpApi.post<Student>('http://localhost:8080/students', Student)
      .pipe(
        map((response: any) => response),
        catchError(async (err) => console.log(err))
      );
  }

}
