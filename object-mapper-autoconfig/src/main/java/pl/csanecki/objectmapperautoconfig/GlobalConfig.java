package pl.csanecki.objectmapperautoconfig;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Configuration
class GlobalConfig {

  private static final String POLISH_DATE_FORMAT = "dd-MM-yyyy";
  static final ObjectMapper POLISH_DATE_OBJECT_MAPPER = new ObjectMapper()
      .registerModule(
          new JavaTimeModule()
              .addDeserializer(
                  LocalDate.class, new LocalDateDeserializer(DateTimeFormatter.ofPattern(POLISH_DATE_FORMAT)))
              .addSerializer(
                  LocalDate.class, new LocalDateSerializer(DateTimeFormatter.ofPattern(POLISH_DATE_FORMAT))));

  private static final String UNITED_STATES_DATE_FORMAT = "MM/dd/yyyy";
  static final ObjectMapper UNITED_STATES_DATE_OBJECT_MAPPER = new ObjectMapper()
      .registerModule(
          new JavaTimeModule()
              .addDeserializer(
                  LocalDate.class, new LocalDateDeserializer(DateTimeFormatter.ofPattern(UNITED_STATES_DATE_FORMAT)))
              .addSerializer(
                  LocalDate.class, new LocalDateSerializer(DateTimeFormatter.ofPattern(UNITED_STATES_DATE_FORMAT))));

}
