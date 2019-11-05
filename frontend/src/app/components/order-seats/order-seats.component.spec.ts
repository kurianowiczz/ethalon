import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { OrderSeatsComponent } from './order-seats.component';

describe('OrderSeatsComponent', () => {
  let component: OrderSeatsComponent;
  let fixture: ComponentFixture<OrderSeatsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ OrderSeatsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OrderSeatsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
