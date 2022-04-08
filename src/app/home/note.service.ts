import { Injectable } from "@angular/core";
import { HttpClient, HttpContext } from "@angular/common/http";
import { Observable } from "rxjs";

import { CollectionModelNote } from "./model/models";
import { BYPASS_AUTH } from "../shared/okta/auth.interceptor";

@Injectable({
  providedIn: "root",
})
export class NoteService {
  private apiServerUrl = "http://localhost:8080";

  constructor(private http: HttpClient) { }

  public getNotes(): Observable<CollectionModelNote> {
    return this.http.get<CollectionModelNote>(`${this.apiServerUrl}/api/notes`, {
      context: new HttpContext().set(BYPASS_AUTH, true),
    });
  }
}
