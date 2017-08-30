import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {HttpModule} from '@angular/http';
import {RouterModule} from '@angular/router';
import {ReactiveFormsModule} from '@angular/forms';
import {DashboardComponent} from './dashboard.component';
import {HeaderComponent} from './header/header.component';
import {MainPageComponent} from './main-page/main-page.component';
import {SubjectsListComponent} from './subjects-list/subjects-list.component';
import {SubjectDetailsComponent} from './subject-details/subject-details.component';
import {StudentsListComponent} from './students-list/students-list.component';
import {StudentDetailsComponent} from './student-details/student-details.component';
import {NewStudentComponent} from './new-student/new-student.component';
import {NewSubjectComponent} from './new-subject/new-subject.component';

import {MdChipsModule} from '@angular/material';
import {NewMarkComponent} from './new-mark/new-mark.component';

@NgModule({
  imports: [
    MdChipsModule,
    CommonModule,
    HttpModule,
    RouterModule,
    ReactiveFormsModule
  ],
  declarations: [

    DashboardComponent,
    HeaderComponent,
    MainPageComponent,
    SubjectsListComponent,
    SubjectDetailsComponent,
    NewSubjectComponent,
    NewStudentComponent,
    StudentsListComponent,
    StudentDetailsComponent,
    NewMarkComponent,
  ],
  providers: []
})
export class DashboardModule {
}
