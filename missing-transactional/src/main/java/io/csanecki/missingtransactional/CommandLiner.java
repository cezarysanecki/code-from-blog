package io.csanecki.missingtransactional;

import io.csanecki.missingtransactional.usecase.UseCases;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

//@Component
public class CommandLiner implements CommandLineRunner {

  private final Testing testing;
  private final UseCases useCases;

  CommandLiner(Testing testing, UseCases useCases) {
    this.testing = testing;
    this.useCases = useCases;
  }

  @Override
  public void run(String... args) {
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
  }
}
