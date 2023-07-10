package io.csanecki.cqrs.dictionary.web;

import io.csanecki.cqrs.dictionary.DraftDictionary;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
@RestController("/dictionaries")
public class DictionaryController {

  private final DraftDictionary dictionary;

  @GetMapping
  DictionaryResource get() {
    return DictionaryResource.builder()
        .countries(dictionary.availableCountries())
        .formOfTransports(dictionary.availableFormOfTransports())
        .build();
  }

}
