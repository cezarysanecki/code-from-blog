package io.csanecki.draft.draft.web;

import io.csanecki.draft.draft.api.DraftId;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
class DraftIdConverter implements Converter<String, DraftId> {

  @Override
  public DraftId convert(String source) {
    return DraftId.of(Long.parseLong(source));
  }

}
