import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BoxresultpageComponent } from './boxresultpage.component';

describe('BoxresultpageComponent', () => {
  let component: BoxresultpageComponent;
  let fixture: ComponentFixture<BoxresultpageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [BoxresultpageComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(BoxresultpageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
