package pl.csanecki;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
public class Employee {

  @Id
  @GeneratedValue
  private Long id;
  @Column
  private String firstname;
  @Column
  private String surname;
  @Column
  private BigDecimal salary;

  protected Employee() {
  }

  public Employee(Long id, String firstname, String surname, BigDecimal salary) {
    this.id = id;
    this.firstname = firstname;
    this.surname = surname;
    this.salary = salary;
  }

  public Long getId() {
    return id;
  }

  public String getFirstname() {
    return firstname;
  }

  public String getSurname() {
    return surname;
  }

  public BigDecimal getSalary() {
    return salary;
  }
}
