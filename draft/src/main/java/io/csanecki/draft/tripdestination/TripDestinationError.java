package io.csanecki.draft.tripdestination;

import io.csanecki.draft.error.api.GlobalError;
import io.csanecki.draft.utils.FieldName;
import io.csanecki.draft.section.Section;
import io.csanecki.draft.error.api.ErrorCode;
import io.csanecki.draft.error.api.LocalError;
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
