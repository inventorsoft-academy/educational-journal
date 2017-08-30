import {Component, OnDestroy, OnInit} from '@angular/core';
import {Subject} from '../../model/subject';
import {Subscription} from 'rxjs/Subscription';
import {Router} from '@angular/router';
import {HttpService} from '../../service/http.service';

@Component({
  selector: 'app-subjects-list',
  templateUrl: './subjects-list.component.html',
  styleUrls: ['./subjects-list.component.css']
})
export class SubjectsListComponent implements OnInit, OnDestroy {


  subjectList: Subject[];

  subscriptions: Subscription[] = [];

  constructor(private httpService: HttpService,
              private router: Router) {
  }

  ngOnInit() {
    this.getSubjects();
  }

  getSubjects() {
    const getSubjectsSubscription = this.httpService.getSubjects()
      .subscribe(
        res => {
          this.subjectList = res;
        }
      );
    this.subscriptions.push(getSubjectsSubscription);
  }

  showSubjectDetails(id) {
    this.router.navigate([`dashboard/subject-details/${id}`]);
  }


  ngOnDestroy(): void {
    this.subscriptions.forEach(
      subscription => {
        subscription.unsubscribe();
      });
  }
}
