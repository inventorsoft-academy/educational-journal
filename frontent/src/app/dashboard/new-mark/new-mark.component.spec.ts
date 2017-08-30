import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NewMarkComponent } from './new-mark.component';

describe('NewMarkComponent', () => {
  let component: NewMarkComponent;
  let fixture: ComponentFixture<NewMarkComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NewMarkComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NewMarkComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
