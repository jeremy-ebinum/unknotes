import { Note } from './note';


/**
 * Embedded collection of Note
 */
export interface EmbeddedCollectionNote {
  /**
   * Resource collection
   */
  notes: Array<Note>;
}
