package io.csanecki.missingtransactional.utils;

public class RuntimeExceptionWIthId extends RuntimeException {

  private final Long id;

  public RuntimeExceptionWIthId(Long id) {
    System.out.println("created exception with id: " + id);
    this.id = id;
  }

  public Long getId() {
    return id;
  }

}
