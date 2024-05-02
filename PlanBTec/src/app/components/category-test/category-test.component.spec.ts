import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CategoryTestComponent } from './category-test.component';

describe('CategoryTestComponent', () => {
  let component: CategoryTestComponent;
  let fixture: ComponentFixture<CategoryTestComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [CategoryTestComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(CategoryTestComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
