package pl.devcezz.mapstruct.decorator;

import lombok.Builder;

@Builder(toBuilder = true)
public class EmployeeDto {

    private String firstname;
    private String surname;
    private String salaryWithEuro;

    public EmployeeDto(String firstname, String surname, String salaryWithEuro) {
        this.firstname = firstname;
        this.surname = surname;
        this.salaryWithEuro = salaryWithEuro;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getSurname() {
        return surname;
    }

    public String getSalaryWithEuro() {
        return salaryWithEuro;
    }
}
