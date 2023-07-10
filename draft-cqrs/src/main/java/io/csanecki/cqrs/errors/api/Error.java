package io.csanecki.cqrs.errors.api;

import io.csanecki.cqrs.utils.ErrorScope;
import io.csanecki.cqrs.utils.Section;

public interface Error {

  Section section();

  ErrorCode errorCode();

  ErrorScope errorScope();

}
