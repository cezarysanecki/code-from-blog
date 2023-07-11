package io.csanecki.missingtransactional;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class ExampleEntity {

  @Id
  @GeneratedValue
  private Long id;

  private String firstField;

  private String secondField;

  protected ExampleEntity() {}

  public Long getId() {
    return id;
  }

  public String getFirstField() {
    return firstField;
  }

  public void setFirstField(String firstField) {
    this.firstField = firstField;
    throw new IllegalStateException("something went wrong");
  }

  public String getSecondField() {
    return secondField;
  }

  public void setSecondField(String secondField) {
    this.secondField = secondField;
  }
}
