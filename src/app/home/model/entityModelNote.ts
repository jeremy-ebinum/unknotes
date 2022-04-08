import { Links } from './links';


export interface EntityModelNote {
  body?: string;
  createdAt?: Date;
  id?: number;
  links?: Links;
  tags?: Array<string>;
  title?: string;
  updatedAt?: Date;
}
