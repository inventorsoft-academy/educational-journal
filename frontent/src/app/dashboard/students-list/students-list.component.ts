import {Component, OnDestroy, OnInit} from '@angular/core';
import {Subscription} from "rxjs/Subscription";
import {Student} from "../../model/student";
import {HttpService} from "../../service/http.service";
import {Router} from "@angular/router";


@Component({
  selector: 'app-students-list',
  templateUrl: './students-list.component.html',
  styleUrls: ['./students-list.component.css']
})
export class StudentsListComponent implements OnInit, OnDestroy {

  studentList: Student[];

  subscriptions: Subscription[] = [];

  constructor(private httpService: HttpService,
              private router: Router) {
  }

  ngOnInit() {
    this.getStudents();
  }

  getStudents() {
    const getStudentsSubscription = this.httpService.getStudents()
      .subscribe(
        res => {
          this.studentList = res;
        }
      );
    this.subscriptions.push(getStudentsSubscription);
  }

  showStudentDetails(id) {
    this.router.navigate([`dashboard/student-details/${id}`]);
  }


  ngOnDestroy(): void {
    this.subscriptions.forEach(
      subscription => {
        subscription.unsubscribe();
      });
  }
}
