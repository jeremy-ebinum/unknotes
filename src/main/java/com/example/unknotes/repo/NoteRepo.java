package com.example.unknotes.repo;

import java.util.List;
import java.util.Optional;

import com.example.unknotes.model.Note;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface NoteRepo extends JpaRepository<Note, Long> {

  void deleteNoteById(@Param("id") Long id);

  Optional<Note> findNoteById(@Param("id") Long id);

  Optional<List<Note>> findAllByUser(@Param("name") String name);

  @Query("SELECT n FROM Note n JOIN n.tags t WHERE t = LOWER(:tag)")
  Optional<List<Note>> retrieveByTag(@Param("tag") String tag);
}
