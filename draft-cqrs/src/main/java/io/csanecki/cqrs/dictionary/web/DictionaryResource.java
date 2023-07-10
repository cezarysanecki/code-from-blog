package io.csanecki.cqrs.dictionary.web;

import io.csanecki.cqrs.landtransport.api.FormOfTransport;
import io.csanecki.cqrs.tripdestination.api.Country;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.NonNull;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Builder(access = AccessLevel.PACKAGE)
@ResponseBody
public class DictionaryResource {

  @NonNull
  List<FormOfTransport> formOfTransports;

  @NonNull
  List<Country> countries;

}
