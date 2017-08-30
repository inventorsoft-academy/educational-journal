import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {HttpService} from './service/http.service';
import {RouterModule} from '@angular/router';
import {DashboardModule} from './dashboard/dashboard.module';
import {DashboardComponent} from './dashboard/dashboard.component';
import {MainPageComponent} from './dashboard/main-page/main-page.component';
import {SubjectsListComponent} from './dashboard/subjects-list/subjects-list.component';
import {SubjectDetailsComponent} from './dashboard/subject-details/subject-details.component';
import {NewSubjectComponent} from './dashboard/new-subject/new-subject.component';
import {NewStudentComponent} from "./dashboard/new-student/new-student.component";
import {StudentsListComponent} from "./dashboard/students-list/students-list.component";
import {StudentDetailsComponent} from "./dashboard/student-details/student-details.component";
import {NewMarkComponent} from "./dashboard/new-mark/new-mark.component";


const routes = [{
  path: 'dashboard',
  component: DashboardComponent,
  children: [
    {
      path: '',
      redirectTo: 'main-page',
      pathMatch: 'full'
    },
    {
      path: 'main-page',
      component: MainPageComponent
    },
    {
      path: 'subjects-list',
      component: SubjectsListComponent
    },
    {
      path: 'subject-details/:id',
      component: SubjectDetailsComponent
    },
    {
      path: 'new-student',
      component: NewStudentComponent
    },
    {
      path: 'students-list',
      component: StudentsListComponent
    },
    {
      path: 'student-details/:id',
      component: StudentDetailsComponent
    },
    {
      path: 'student-details-addMark/:id',
      component: NewMarkComponent
    },
    {
      path: 'new-subject',
      component: NewSubjectComponent
    }
  ]
},
  {
    path: '',
    redirectTo: 'dashboard',
    pathMatch: 'full'
  }
];

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    DashboardModule,
    RouterModule.forRoot(routes)
  ],
  providers: [HttpService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
