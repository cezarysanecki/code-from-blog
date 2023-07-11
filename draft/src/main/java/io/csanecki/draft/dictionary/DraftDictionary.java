package io.csanecki.draft.dictionary;

import io.csanecki.draft.landtransport.api.FormOfTransport;
import io.csanecki.draft.tripdestination.api.Country;

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
