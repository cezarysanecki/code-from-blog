package io.csanecki.draft.error.web;

import io.csanecki.draft.error.api.ErrorCode;
import io.csanecki.draft.utils.ErrorScope;
import io.csanecki.draft.utils.FieldName;
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
