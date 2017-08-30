import {Component, OnDestroy} from '@angular/core';
import {HttpService} from "../../service/http.service";
import {FormBuilder, Validators} from "@angular/forms";
import {Subscription} from "rxjs/Subscription";

@Component({
  selector: 'app-new-student',
  templateUrl: './new-student.component.html',
  styleUrls: ['./new-student.component.css']
})
export class NewStudentComponent implements OnDestroy {

  newStudentForm = this.fb.group({
    firstName: ['', Validators.required],
    lastName: ['', Validators.required],
    birthDay: ['', Validators.required],
    group: ['', Validators.required],
  });

  subscriptions: Subscription[] = [];


  constructor(private fb: FormBuilder, private httpService: HttpService) {
  }


  saveStudent() {
    const saveStudent = this.httpService.saveStudent(this.newStudentForm.value).subscribe();
    this.subscriptions.push(saveStudent);
    this.clearForm();
  }

  clearForm() {
    this.newStudentForm.reset();
  }

  ngOnDestroy(): void {
    this.subscriptions.forEach(
      subscription => {
        subscription.unsubscribe();
      });
  }
}
