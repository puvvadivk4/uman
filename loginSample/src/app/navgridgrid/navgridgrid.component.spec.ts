import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NavgridgridComponent } from './navgridgrid.component';

describe('NavgridgridComponent', () => {
  let component: NavgridgridComponent;
  let fixture: ComponentFixture<NavgridgridComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NavgridgridComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NavgridgridComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
