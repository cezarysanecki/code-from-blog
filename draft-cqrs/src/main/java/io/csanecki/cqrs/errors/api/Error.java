package io.csanecki.cqrs.errors.api;

import io.csanecki.cqrs.draft.ErrorScope;
import io.csanecki.cqrs.draft.Section;

public interface Error {

  Section section();

  ErrorCode errorCode();

  ErrorScope errorScope();

}
