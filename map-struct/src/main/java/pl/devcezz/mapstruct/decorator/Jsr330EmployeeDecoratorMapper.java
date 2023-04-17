package pl.devcezz.mapstruct.decorator;

import javax.inject.Inject;
import javax.inject.Named;

public abstract class Jsr330EmployeeDecoratorMapper implements EmployeeMapper {

    @Inject
    @Named("pl.devcezz.mapstruct.decorator.EmployeeMapperImpl_")
    private EmployeeMapper delegate;

    @Inject
    private SalaryService employeeService;

    @Override
    public EmployeeDto map(Employee employee) {
        EmployeeDto dto = delegate.map(employee);
        return dto.toBuilder()
                .salaryWithEuro(employeeService.formatSalary(employee.getSalary()))
                .build();
    }

    @Override
    public Employee map(EmployeeDto dto) {
        Employee employee = delegate.map(dto);
        return employee.toBuilder()
                .salary(employeeService.extractSalary(dto.getSalaryWithEuro()))
                .build();
    }
}
