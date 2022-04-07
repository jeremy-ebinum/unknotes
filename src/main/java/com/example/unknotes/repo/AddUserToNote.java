package com.example.unknotes.repo;

import com.example.unknotes.model.Note;

import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
@RepositoryEventHandler(Note.class)
public class AddUserToNote {

  @HandleBeforeCreate
  void handleCreate(Note note) {
    String username = SecurityContextHolder.getContext().getAuthentication().getName();
    System.out.println("Creating note: " + note + " with user: " + username);
    note.setUser(username);
  }
}
