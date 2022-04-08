package com.example.unknotes.service;

import java.security.Principal;
import java.util.List;

import com.example.unknotes.model.Note;

import org.springframework.stereotype.Service;

@Service
public interface NoteService {

  Note addNote(Note note);

  List<Note> findAllNotes();

  Note updateNote(Note note);

  void deleteNote(Long id);

  Note findNoteById(Long id);

  List<Note> findNotesByUser(Principal principal);

  List<Note> retrieveByTag(String tag);
}
