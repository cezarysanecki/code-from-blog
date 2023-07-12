package io.csanecki.missingtransactional.usecase;

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

  public ExampleEntity() {}

  public Long getId() {
    return id;
  }

  public String getFirstField() {
    return firstField;
  }

  public void setFirstField(String firstField) {
    this.firstField = firstField;
  }

  public void setFirstFieldWithRuntimeException(String firstField) {
    this.firstField = firstField;
    throw new IllegalStateException("something went wrong");
  }

  public String getSecondField() {
    return secondField;
  }

  public void setSecondField(String secondField) {
    this.secondField = secondField;
  }

  @Override
  public String toString() {
    return "ExampleEntity{" +
        "id=" + id +
        ", firstField='" + firstField + '\'' +
        ", secondField='" + secondField + '\'' +
        '}';
  }
}
