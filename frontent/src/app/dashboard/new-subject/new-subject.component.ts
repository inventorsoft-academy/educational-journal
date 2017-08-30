import {Component, OnDestroy} from '@angular/core';
import {FormBuilder, Validators} from '@angular/forms';
import {Subscription} from 'rxjs/Subscription';
import {HttpService} from '../../service/http.service';

@Component({
  selector: 'app-new-subject',
  templateUrl: './new-subject.component.html',
  styleUrls: ['./new-subject.component.css']
})
export class NewSubjectComponent implements OnDestroy {

  newSubjectForm = this.fb.group({
    name: ['', Validators.required]
  });

  subscriptions: Subscription[] = [];

  constructor(private fb: FormBuilder,
              private httpService: HttpService) {
  }

  saveSubject() {
    const saveSubject = this.httpService.saveSubject(this.newSubjectForm.value).subscribe();
    this.subscriptions.push(saveSubject);
    this.clearForm();
  }

  clearForm() {
    this.newSubjectForm.reset();
  }

  ngOnDestroy(): void {
    this.subscriptions.forEach(
      subscription => {
        subscription.unsubscribe();
      });
  }
}
