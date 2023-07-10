package io.csanecki.cqrs.infrastructure;

import io.csanecki.cqrs.draft.api.DraftProcessException;
import io.csanecki.cqrs.draft.api.DraftValidationException;
import io.csanecki.cqrs.error.api.Error;
import io.csanecki.cqrs.error.web.ErrorResource;
import io.csanecki.cqrs.error.web.ErrorResourceProjection;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Set;

@ControllerAdvice
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
public class ErrorAdviceController {

  private final ErrorResourceProjection errorResourceProjection;

  @ExceptionHandler(DraftValidationException.class)
  public ResponseEntity<Error> handle(@NonNull DraftValidationException exception) {
    return ResponseEntity
        .status(HttpStatus.FORBIDDEN)
        .body(exception.getError());
  }


  @ExceptionHandler(DraftProcessException.class)
  public ResponseEntity<Set<ErrorResource>> handle(@NonNull DraftProcessException exception) {
    return ResponseEntity
        .status(HttpStatus.FORBIDDEN)
        .body(errorResourceProjection.findProjectionAllByDraftId(exception.getDraftId()));
  }

}
