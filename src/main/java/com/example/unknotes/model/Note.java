package com.example.unknotes.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Note extends BaseEntity implements Serializable {

  private String title;
  private String body;
  @ElementCollection
  private List<String> tags = new ArrayList<>();
  @JsonIgnore
  private String user;
}
