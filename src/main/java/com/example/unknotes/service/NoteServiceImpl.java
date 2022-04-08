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
public class NoteServiceImpl implements NoteService {
  @Autowired
  private NoteRepo noteRepo;

  @Override
  public Note addNote(Note note) {
    return noteRepo.save(note);
  }

  @Override
  public List<Note> findAllNotes() {
    return noteRepo.findAll();
  }

  @Override
  public Note updateNote(Note note) {
    return noteRepo.save(note);
  }

  @Override
  public void deleteNote(Long id) {
    noteRepo.deleteById(id);
  }

  @Override
  public Note findNoteById(Long id) {
    return noteRepo.findNoteById(id)
        .orElseThrow(() -> new NoteNotFoundException("Note with id " + id + " was not found"));
  }

  @Override
  public List<Note> retrieveByTag(String tag) {
    return noteRepo.retrieveByTag(tag).orElseGet(() -> new ArrayList<Note>());
  }

  @Override
  public List<Note> findNotesByUser(Principal principal) {
    return noteRepo.findAllByUser(principal.getName()).orElseGet(() -> new ArrayList<Note>());
  }
}
