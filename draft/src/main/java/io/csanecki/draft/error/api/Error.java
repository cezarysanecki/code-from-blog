package io.csanecki.draft.error.api;

import io.csanecki.draft.utils.ErrorScope;
import io.csanecki.draft.section.Section;

public interface Error {

  Section section();

  ErrorCode errorCode();

  ErrorScope errorScope();

}
