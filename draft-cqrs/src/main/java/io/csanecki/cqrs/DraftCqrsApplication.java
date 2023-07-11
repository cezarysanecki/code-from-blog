package io.csanecki.cqrs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

@SpringBootApplication
public class DraftCqrsApplication implements ApplicationListener<ContextRefreshedEvent> {

  private static final Logger LOGGER = LoggerFactory.getLogger(DraftCqrsApplication.class);

  public static void main(String[] args) {
    SpringApplication.run(DraftCqrsApplication.class, args);
  }

  @Override
  public void onApplicationEvent(ContextRefreshedEvent event) {
    ApplicationContext applicationContext = event.getApplicationContext();
    RequestMappingHandlerMapping requestMappingHandlerMapping = applicationContext
        .getBean(RequestMappingHandlerMapping.class);
    requestMappingHandlerMapping
        .getHandlerMethods()
        .forEach((key, value) -> LOGGER.debug("{} {}", key, value));
  }
}
