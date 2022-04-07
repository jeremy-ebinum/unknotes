package com.example.unknotes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import javax.annotation.PostConstruct;

import com.example.unknotes.model.Note;
import com.example.unknotes.repo.NoteRepo;
import com.github.javafaker.Faker;

@Component
public class DataInitializer {
  @Autowired
  private NoteRepo noteRepo;
  private Faker faker;

  @PostConstruct
  private void postConstruct() {
    this.faker = new Faker();

    // Generate Fake Notes if none exist
    if (noteRepo.findAll().size() == 0) {

      List<String> titles = Arrays.asList(faker.book().title(), faker.book().title(), faker.book().title(),
          faker.book().title(), faker.book().title());

      titles.forEach(title -> {
        Note newNote = new Note();
        newNote.setTitle(title);
        newNote.setUser(faker.name().username());
        newNote.setBody(faker.lorem().paragraph());
        int numberOfTags = new Random().nextInt(4);
        ArrayList<String> tags = new ArrayList<>();

        for (int i = 0; i < numberOfTags; i++) {
          tags.add(faker.book().genre());
        }

        newNote.setTags(tags);

        noteRepo.save(newNote);
      });
    }
  }
}
