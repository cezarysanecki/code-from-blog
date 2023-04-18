package pl.csanecki;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class EmployeeProjectionController {

  private final EmployeeRepository employeeRepository;

  public EmployeeProjectionController(EmployeeRepository employeeRepository) {
    this.employeeRepository = employeeRepository;
  }

  @GetMapping("/{id}")
  public EmployeeNameDto findEmployeeNameById(@PathVariable("id") Long id) {
    return employeeRepository.findEmployeeNameById(id);
  }
}
