import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LocalArmazenamentoComponent } from './local-armazenamento.component';

describe('LocalArmazenamentoComponent', () => {
  let component: LocalArmazenamentoComponent;
  let fixture: ComponentFixture<LocalArmazenamentoComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [LocalArmazenamentoComponent]
    });
    fixture = TestBed.createComponent(LocalArmazenamentoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
