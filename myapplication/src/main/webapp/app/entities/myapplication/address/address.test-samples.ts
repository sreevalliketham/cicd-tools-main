import { IAddress, NewAddress } from './address.model';

export const sampleWithRequiredData: IAddress = {
  id: 11430,
};

export const sampleWithPartialData: IAddress = {
  id: 4321,
  aid: 'sedately',
  citi: 'yahoo',
};

export const sampleWithFullData: IAddress = {
  id: 26393,
  aid: 'gator',
  street: 'Rosalind Streets',
  citi: 'decent',
};

export const sampleWithNewData: NewAddress = {
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);
