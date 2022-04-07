package com.example.unknotes.service;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import com.example.unknotes.exception.NoteNotFoundException;
import com.example.unknotes.model.Note;
import com.example.unknotes.repo.NoteRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoteService {
  private NoteRepo noteRepo;

  @Autowired
  public NoteService(NoteRepo noteRepo) {
    this.noteRepo = noteRepo;
  }

  // CREATE
  public Note addNote(Note note) {
    return noteRepo.save(note);
  }

  // READ
  public List<Note> findAllNotes() {
    return noteRepo.findAll();
  }

  // UPDATE
  public Note updateNote(Note note) {
    return noteRepo.save(note);
  }

  // DELETE
  public void deleteNote(Long id) {
    noteRepo.deleteById(id);
  }

  // FIND BY ID
  public Note findNoteById(Long id) {
    return noteRepo.findNoteById(id)
        .orElseThrow(() -> new NoteNotFoundException("Note with id " + id + " was not found"));
  }

  // FIND NOTES BY USER
  public List<Note> findNotesByUser(Principal principal) {
    return noteRepo.findAllByUser(principal.getName()).orElseGet(() -> new ArrayList<Note>());
  }

  // FIND NOTES BY TAG
  public List<Note> retrieveByTag(String tag) {
    return noteRepo.retrieveByTag(tag).orElseGet(() -> new ArrayList<Note>());
  }
}
