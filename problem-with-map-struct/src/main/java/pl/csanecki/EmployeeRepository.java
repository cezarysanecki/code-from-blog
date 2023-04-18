package pl.csanecki;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "employees", path = "employees")
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

  @Query("SELECT new pl.csanecki.EmployeeNameDto(e.firstname, e.surname) FROM Employee e WHERE e.id = :id")
  EmployeeNameDto findEmployeeNameById(@Param("id") Long id);

}
