import {Component, OnDestroy, OnInit} from '@angular/core';
import {Subscription} from "rxjs/Subscription";
import {Student} from "../../model/student";
import {ActivatedRoute, Router} from "@angular/router";
import {HttpService} from "../../service/http.service";


@Component({
  selector: 'app-student-details',
  templateUrl: './student-details.component.html',
  styleUrls: ['./student-details.component.css']
})
export class StudentDetailsComponent implements OnInit, OnDestroy {

  student: Student;

  subscriptions: Subscription[] = [];

  constructor(private route: ActivatedRoute, private httpService: HttpService, private router: Router) {
  }

  ngOnInit() {
    this.findStudentById(this.route.snapshot.params.id);
  }

  findStudentById(id) {
    const findStudent = this.httpService.findStudentById(id).subscribe(
      res => {
        this.student = res;
      });
    this.subscriptions.push(findStudent);
  }

  addMark(id) {
    this.router.navigate([`dashboard/student-details-addMark/${id}`]);
  }


  ngOnDestroy(): void {
    this.subscriptions.forEach(
      subscription => {
        subscription.unsubscribe();
      });
  }
}
