import { TestBed } from '@angular/core/testing';

import { GouvernoratDelegationserviceService } from './gouvernorat-delegationservice.service';

describe('GouvernoratDelegationserviceService', () => {
  let service: GouvernoratDelegationserviceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(GouvernoratDelegationserviceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
