package io.csanecki.draft.landtransport;

import io.csanecki.draft.error.api.ErrorCode;
import io.csanecki.draft.error.api.GlobalError;
import io.csanecki.draft.error.api.LocalError;
import io.csanecki.draft.section.Section;
import io.csanecki.draft.utils.FieldName;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
final class LandTransportError {

  static GlobalError GLOBAL_FORM_OF_TRANSPORT_NEEDS_DESTINATION = GlobalError.of(
      Section.LAND_TRANSPORT, ErrorCode.of("NEEDS_DESTINATION"));
  static GlobalError GLOBAL_LAND_TRANSPORT_IS_NOT_EDITABLE = GlobalError.of(
      Section.LAND_TRANSPORT, ErrorCode.UNEDITABLE);

  static LocalError LOCAL_FORM_OF_TRANSPORT_REQUIRED = LocalError.of(
      Section.LAND_TRANSPORT, ErrorCode.REQUIRED_FIELD, FieldName.of(Fields.FORM_OF_TRANSPORT));
  static LocalError LOCAL_FORM_OF_TRANSPORT_WRONG_VALUE = LocalError.of(
      Section.LAND_TRANSPORT, ErrorCode.WRONG_VALUE, FieldName.of(Fields.FORM_OF_TRANSPORT));
}
