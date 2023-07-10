package io.csanecki.cqrs.tripdestination;

import io.csanecki.cqrs.draft.FieldName;
import io.csanecki.cqrs.draft.Section;
import io.csanecki.cqrs.errors.api.ErrorCode;
import io.csanecki.cqrs.errors.api.LocalError;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
final class TripDestinationError {

  static LocalError LOCAL_DESTINATION_REQUIRED = LocalError.of(
      Section.TRIP_DESTINATION, ErrorCode.REQUIRED_FIELD, FieldName.of(Fields.DESTINATION));

}
