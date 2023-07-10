package io.csanecki.cqrs.dictionary.web;

import io.csanecki.cqrs.dictionary.DraftDictionary;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dictionaries")
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
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
