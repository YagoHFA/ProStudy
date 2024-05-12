import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ContractpageComponent } from './contractpage.component';

describe('ContractpageComponent', () => {
  let component: ContractpageComponent;
  let fixture: ComponentFixture<ContractpageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ContractpageComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ContractpageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
