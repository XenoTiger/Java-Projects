import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PrintTransactionComponent } from './print-transaction.component';

describe('PrintTransactionComponent', () => {
  let component: PrintTransactionComponent;
  let fixture: ComponentFixture<PrintTransactionComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PrintTransactionComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PrintTransactionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
