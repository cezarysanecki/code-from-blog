package io.csanecki.cqrs.landtransport;

import io.csanecki.cqrs.error.api.ErrorCode;
import io.csanecki.cqrs.error.api.GlobalError;
import io.csanecki.cqrs.error.api.LocalError;
import io.csanecki.cqrs.section.Section;
import io.csanecki.cqrs.utils.FieldName;
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
}
