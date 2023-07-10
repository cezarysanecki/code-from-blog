package io.csanecki.cqrs.error.web;

import io.csanecki.cqrs.error.api.ErrorCode;
import io.csanecki.cqrs.utils.ErrorScope;
import io.csanecki.cqrs.utils.FieldName;
import lombok.*;
import org.springframework.web.bind.annotation.ResponseBody;

@ResponseBody
@Value
@Builder(access = AccessLevel.PACKAGE)
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class ErrorResource {

  FieldName fieldName;

  ErrorScope errorScope;

  ErrorCode errorCode;

}
