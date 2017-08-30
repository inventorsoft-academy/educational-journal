import {Component, OnDestroy, OnInit} from '@angular/core';
import {Subscription} from 'rxjs/Subscription';
import {Subject} from '../../model/subject';
import {ActivatedRoute} from '@angular/router';
import {HttpService} from '../../service/http.service';

@Component({
  selector: 'app-subject-details',
  templateUrl: './subject-details.component.html',
  styleUrls: ['./subject-details.component.css']
})
export class SubjectDetailsComponent implements OnInit, OnDestroy {

  subject: Subject;

  subscriptions: Subscription[] = [];

  constructor(private route: ActivatedRoute, private httpService: HttpService) {}

  ngOnInit() {
    this.findSubjectById(this.route.snapshot.params.id);
  }

  findSubjectById(id) {
    const findSubject = this.httpService.findSubjectById(id)
      .subscribe(
        res => {
          this.subject = res;
        }
      );
    this.subscriptions.push(findSubject);
  }

  ngOnDestroy(): void {
    this.subscriptions.forEach(
      subscription => {
        subscription.unsubscribe();
      });
  }
}
