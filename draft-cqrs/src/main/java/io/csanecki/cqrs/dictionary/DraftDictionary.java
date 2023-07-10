package io.csanecki.cqrs.dictionary;

import io.csanecki.cqrs.landtransport.api.FormOfTransport;
import io.csanecki.cqrs.tripdestination.api.Country;

import java.util.Arrays;
import java.util.List;

public class DraftDictionary {

  public List<FormOfTransport> availableFormOfTransports() {
    return Arrays.stream(FormOfTransport.values()).toList();
  }

  public List<Country> availableCountries() {
    return Arrays.stream(Country.values()).toList();
  }

}
