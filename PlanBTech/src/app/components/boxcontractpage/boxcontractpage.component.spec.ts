import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BoxcontractpageComponent } from './boxcontractpage.component';

describe('BoxcontractpageComponent', () => {
  let component: BoxcontractpageComponent;
  let fixture: ComponentFixture<BoxcontractpageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [BoxcontractpageComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(BoxcontractpageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
