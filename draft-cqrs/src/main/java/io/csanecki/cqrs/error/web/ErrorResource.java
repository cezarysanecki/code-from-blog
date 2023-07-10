package io.csanecki.cqrs.error.web;

import io.csanecki.cqrs.error.api.ErrorCode;
import io.csanecki.cqrs.utils.ErrorScope;
import io.csanecki.cqrs.utils.FieldName;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.ResponseBody;

@Setter
@Getter
@ResponseBody
public class ErrorResource {

  private FieldName fieldName;

  private ErrorScope errorScope;

  private ErrorCode errorCode;

  public ErrorResource(
      FieldName fieldName,
      ErrorScope errorScope,
      ErrorCode errorCode
  ) {
    this.fieldName = fieldName;
    this.errorScope = errorScope;
    this.errorCode = errorCode;
  }
}
