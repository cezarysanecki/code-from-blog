package io.csanecki.cqrs.tripdestination;

import io.csanecki.cqrs.error.api.GlobalError;
import io.csanecki.cqrs.utils.FieldName;
import io.csanecki.cqrs.section.Section;
import io.csanecki.cqrs.error.api.ErrorCode;
import io.csanecki.cqrs.error.api.LocalError;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
final class TripDestinationError {

  static LocalError LOCAL_DESTINATION_REQUIRED = LocalError.of(
      Section.TRIP_DESTINATION, ErrorCode.REQUIRED_FIELD, FieldName.of(Fields.DESTINATION));
  static LocalError LOCAL_DESTINATION_WRONG_VALUE = LocalError.of(
      Section.TRIP_DESTINATION, ErrorCode.WRONG_VALUE, FieldName.of(Fields.DESTINATION));
  static GlobalError GLOBAL_TRIP_DESTINATION_IS_NOT_EDITABLE = GlobalError.of(
      Section.TRIP_DESTINATION, ErrorCode.UNEDITABLE);

}
