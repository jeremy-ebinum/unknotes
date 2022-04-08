import { LinkRelation } from './linkRelation';


export interface Link {
  deprecation?: string;
  href?: string;
  hreflang?: string;
  media?: string;
  name?: string;
  profile?: string;
  rel?: LinkRelation;
  title?: string;
  type?: string;
}
