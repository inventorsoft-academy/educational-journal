import {Injectable} from '@angular/core';
import {Http, Response} from '@angular/http';
import {Observable} from 'rxjs/Observable';
import {Subject} from '../model/subject';
import {Student} from '../model/student';

import 'rxjs/add/operator/map';

@Injectable()
export class HttpService {

  private Path = 'http://localhost:8080/';

  constructor(private http: Http) {
  }

  getSubjects(): Observable<Subject[]> {
    const url = `${this.Path}subjects`;
    return this.http.get(url)
      .map(res => res.json());
  }


  findSubjectById(id): Observable<Subject> {
    const url = `${this.Path}subjects/${id}`;
    return this.http.get(url)
      .map(res => res.json());

  }

  findStudentById(id): Observable<Student> {
    const url = `${this.Path}students/${id}`;
    return this.http.get(url)
      .map(res => res.json());

  }

  addMarkToStudent(id, obj: {}): Observable<Response> {
    const url = `${this.Path}students/${id}`;
    return this.http.put(url, obj);
  }


  saveSubject(obj: {}): Observable<Response> {
    const url = `${this.Path}subjects`;
    return this.http.post(url, obj);
  }

  deleteSubjectById(id) {
    const url = `${this.Path}subjects/${id}`;
    return this.http.delete(url);
  }

  getStudents(): Observable<Student[]> {
    const url = `${this.Path}students`;
    return this.http.get(url)
      .map(res => res.json());
  }

  saveStudent(obj: {}): Observable<Response> {
    const url = `${this.Path}students`;
    return this.http.post(url, obj);
  }

  deleteStudentById(id) {
    const url = `${this.Path}students/${id}`;
    return this.http.delete(url);
  }
}
