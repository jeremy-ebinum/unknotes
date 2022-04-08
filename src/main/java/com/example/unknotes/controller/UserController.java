package com.example.unknotes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.security.Principal;
import java.util.List;

import com.example.unknotes.model.Note;
import com.example.unknotes.service.NoteServiceImpl;

@RestController
@CrossOrigin(origins = "http://localhost:4200") // CORS
public class UserController {
  @Autowired
  private NoteServiceImpl noteService;

  @GetMapping("/user")
  public ResponseEntity<OidcUser> user(@AuthenticationPrincipal OidcUser user) {
    return new ResponseEntity<>(user, HttpStatus.OK);
  }

  @GetMapping("/user/notes")
  public ResponseEntity<List<Note>> notes(Principal principal) {
    List<Note> notes = noteService.findNotesByUser(principal);

    return new ResponseEntity<>(notes, HttpStatus.OK);
  }

}
