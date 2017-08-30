import {Component, OnDestroy, OnInit} from '@angular/core';
import {FormBuilder, Validators} from "@angular/forms";
import {HttpService} from "../../service/http.service";
import {Subscription} from "rxjs/Subscription";
import {Subject} from "../../model/subject";


@Component({
  selector: 'app-new-mark',
  templateUrl: './new-mark.component.html',
  styleUrls: ['./new-mark.component.css']
})
export class NewMarkComponent implements OnDestroy, OnInit {

  newMarkForm = this.fb.group({
    mark: ['', Validators.required],
    subjects: ['', Validators.required]

  });
  subjectList: Subject[];
  subscriptions: Subscription[] = [];


  constructor(private fb: FormBuilder, private httpService: HttpService) {
  }


  addMarkToStudent(id) {
    const markOfStudent = this.httpService.addMarkToStudent(id, this.newMarkForm.value).subscribe();
    this.subscriptions.push(markOfStudent);
    this.clearForm();
  }

  clearForm() {
    this.newMarkForm.reset();
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


  ngOnDestroy(): void {
    this.subscriptions.forEach(
      subscription => {
        subscription.unsubscribe();
      });
  }
}
