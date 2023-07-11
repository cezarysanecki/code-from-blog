package io.csanecki.draft.dictionary.web;

import io.csanecki.draft.landtransport.api.FormOfTransport;
import io.csanecki.draft.tripdestination.api.Country;
import lombok.*;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@ResponseBody
@Getter
@Builder(access = AccessLevel.PACKAGE)
public class DictionaryResource {

  @NonNull
  List<FormOfTransport> formOfTransports;

  @NonNull
  List<Country> countries;

}
