package io.csanecki.missingtransactional;

import io.csanecki.missingtransactional.usecase.UseCases;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MissingTransactionalApplication {

  public static void main(String[] args) {
    SpringApplication.run(MissingTransactionalApplication.class, args);
  }

  @Bean
  CommandLineRunner init(Testing testing, UseCases useCases) {
    return args -> {
      try {
        testing.withoutTransaction("without transactional - two saves",
            id -> useCases.updateTwoSaves(id, "1-1", "1-2"));
      } catch (Exception exception) {
        System.out.println("there is exception");
      }
      System.out.println();
      try {
        testing.withoutTransaction("without transactional - one save",
            id -> useCases.updateOneSave(id, "2-1", "2-2"));
      } catch (Exception exception) {
        System.out.println("there is exception");
      }
      System.out.println();
      try {
        testing.withoutTransaction("without transactional - zero saves",
            id -> useCases.updateWithoutSave(id, "3-1", "3-2"));
      } catch (Exception exception) {
        System.out.println("there is exception");
      }

      System.out.println("-------");

      try {
        testing.withTransaction("with transactional - two saves",
            id -> useCases.updateTwoSaves(id, "1-1", "1-2"));
      } catch (Exception exception) {
        System.out.println("there is exception");
      }
      System.out.println();
      try {
        testing.withTransaction("with transactional - one save",
            id -> useCases.updateOneSave(id, "2-1", "2-2"));
      } catch (Exception exception) {
        System.out.println("there is exception");
      }
      System.out.println();
      try {
        testing.withTransaction("with transactional - zero saves",
            id -> useCases.updateWithoutSave(id, "3-1", "3-2"));
      } catch (Exception exception) {
        System.out.println("there is exception");
      }
    };
  }

}
