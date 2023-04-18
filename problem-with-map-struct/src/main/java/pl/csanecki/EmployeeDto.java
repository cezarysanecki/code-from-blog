package pl.csanecki;

import java.math.BigDecimal;

public class EmployeeDto {

  private final Long id;
  private final String firstname;
  private final String surname;
  private final BigDecimal salary;

  public EmployeeDto(Long id, String firstname, String surname, BigDecimal salary) {
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
