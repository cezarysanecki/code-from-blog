package pl.devcezz.mapstruct.decorator;

import lombok.Builder;

import java.math.BigDecimal;

@Builder(toBuilder = true)
public class Employee {

    private String firstname;
    private String surname;
    private BigDecimal salary;

    public Employee(String firstname, String surname, BigDecimal salary) {
        this.firstname = firstname;
        this.surname = surname;
        this.salary = salary;
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
