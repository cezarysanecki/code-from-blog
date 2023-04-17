package pl.devcezz.mapstruct.decorator;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.inject.Inject;
import javax.inject.Named;
import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class EmployeeMapperIntTest {

    @Inject
    @Named
    EmployeeMapper employeeMapper;

    @Test
    void should_map_employee_to_employee_dto() {
        Employee employee = new Employee(
                "Jan",
                "Kowalski",
                BigDecimal.valueOf(2800.00)
        );

        EmployeeDto result = employeeMapper.map(employee);

        assertThat(result.getFirstname()).isEqualTo("Jan");
        assertThat(result.getSurname()).isEqualTo("Kowalski");
        assertThat(result.getSalaryWithEuro()).isEqualTo("2800.00€");
    }

    @Test
    void should_map_employee_dto_to_employee() {
        EmployeeDto dto = new EmployeeDto(
                "Albert",
                "Poniatowski",
                "9020.00€"
        );

        Employee result = employeeMapper.map(dto);

        assertThat(result.getFirstname()).isEqualTo("Albert");
        assertThat(result.getSurname()).isEqualTo("Poniatowski");
        assertThat(result.getSalary())
                .isEqualTo(BigDecimal.valueOf(9020.00).setScale(2, RoundingMode.HALF_UP));
    }
}
