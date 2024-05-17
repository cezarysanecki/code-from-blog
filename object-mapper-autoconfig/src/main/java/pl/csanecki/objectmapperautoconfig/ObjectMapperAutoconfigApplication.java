package pl.csanecki.objectmapperautoconfig;

import lombok.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class ObjectMapperAutoconfigApplication implements CommandLineRunner {

  public static void main(String[] args) {
    SpringApplication.run(ObjectMapperAutoconfigApplication.class, args);
  }

  @Override
  public void run(final String... args) throws Exception {
    Person person = new Person(
        "Jan",
        "Kowalski",
        LocalDate.of(1970, 10, 3));

    String personPolishJson = GlobalConfig.POLISH_DATE_OBJECT_MAPPER.writeValueAsString(person);
    System.out.println(personPolishJson);

    String personUnitedStatesJson = GlobalConfig.UNITED_STATES_DATE_OBJECT_MAPPER.writeValueAsString(person);
    System.out.println(personUnitedStatesJson);
  }

  @Value
  static class Person {

    String firstname;
    String lastname;
    LocalDate dateOfBirth;

  }

}
