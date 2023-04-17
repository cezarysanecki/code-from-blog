package pl.devcezz.mapstruct.decorator;

import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;

@Mapper(componentModel = "jsr330")
@DecoratedWith(Jsr330EmployeeDecoratorMapper.class)
public interface EmployeeMapper {

    EmployeeDto map(Employee employee);

    Employee map(EmployeeDto dto);
}
