import { EmbeddedCollectionNote } from './embeddedCollectionNote';
import { Link } from './link';


/**
 * Resources of Note
 */
export interface CollectionModelNote {
  _embedded: EmbeddedCollectionNote;
  /**
   * Link collection
   */
  _links: { [key: string]: Link; };
}
