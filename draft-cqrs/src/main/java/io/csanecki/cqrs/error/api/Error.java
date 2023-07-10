package io.csanecki.cqrs.error.api;

import io.csanecki.cqrs.utils.ErrorScope;
import io.csanecki.cqrs.section.Section;

public interface Error {

  Section section();

  ErrorCode errorCode();

  ErrorScope errorScope();

}
