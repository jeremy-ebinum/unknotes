export interface Note {
  id: number;
  tags?: Array<string>;
  body: string;
  title: string;
  createdAt?: Date;
  updatedAt?: Date;
}
