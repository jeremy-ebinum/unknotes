package com.example.unknotes.exception;

public class NoteNotFoundException extends RuntimeException {

  public NoteNotFoundException(String message) {
    super(message);
  }
}
