package io.csanecki.cqrs.dictionary;

import io.csanecki.cqrs.landtransport.DefaultFormOfTransportForDestination;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class DictionaryConfig {

  @Bean
  DefaultFormOfTransportForDestination defaultFormOfTransportForDestination() {
    return new DefaultFormOfTransportForDestinationDictionary();
  }

  @Bean
  DraftDictionary draftDictionary() {
    return new DraftDictionary();
  }

}
