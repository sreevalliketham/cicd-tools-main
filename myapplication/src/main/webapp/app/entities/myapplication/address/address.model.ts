export interface IAddress {
  id: number;
  aid?: string | null;
  street?: string | null;
  citi?: string | null;
  onetoone?: IAddress | null;
  addresses?: IAddress[] | null;
}

export type NewAddress = Omit<IAddress, 'id'> & { id: null };
