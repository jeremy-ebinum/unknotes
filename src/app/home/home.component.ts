import { Component, Inject, OnInit } from "@angular/core";
import { HttpErrorResponse } from "@angular/common/http";
import { OKTA_AUTH, OktaAuthStateService } from "@okta/okta-angular";
import { OktaAuth } from "@okta/okta-auth-js";

import { NoteService } from "./note.service";

import { CollectionModelNote, Note } from "./model/models";

@Component({
  selector: "app-home",
  templateUrl: "./home.component.html",
  styleUrls: ["./home.component.css"],
})
export class HomeComponent implements OnInit {
  public notes: Note[] = [];

  constructor(
    @Inject(OKTA_AUTH) public oktaAuth: OktaAuth,
    public authService: OktaAuthStateService,
    private noteService: NoteService
  ) { }

  ngOnInit() {
    this.getNotes();
  }

  public getNotes(): void {
    this.noteService.getNotes().subscribe({
      next: (result: CollectionModelNote) => {
        this.notes = result._embedded.notes;
      },
      error: (err: HttpErrorResponse) => {
        alert(err.message);
      },
    });
  }
}
