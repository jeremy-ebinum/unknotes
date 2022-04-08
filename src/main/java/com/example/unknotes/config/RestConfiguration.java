package com.example.unknotes.config;

import com.example.unknotes.model.Note;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class RestConfiguration {

  @Bean
  public RepositoryRestConfigurer repositoryRestConfigurer() {
    return new RepositoryRestConfigurer() {

      @Override
      public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        config.exposeIdsFor(Note.class);
        config.setBasePath("/api");
      }

    };
  }
}
