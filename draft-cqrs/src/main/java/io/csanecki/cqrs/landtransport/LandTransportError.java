package io.csanecki.cqrs.landtransport;

import io.csanecki.cqrs.utils.FieldName;
import io.csanecki.cqrs.utils.Section;
import io.csanecki.cqrs.errors.api.ErrorCode;
import io.csanecki.cqrs.errors.api.GlobalError;
import io.csanecki.cqrs.errors.api.LocalError;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
final class LandTransportError {

  static GlobalError GLOBAL_FORM_OF_TRANSPORT_NEEDS_DESTINATION = GlobalError.of(
      Section.LAND_TRANSPORT, ErrorCode.of("NEEDS_DESTINATION"));

  static LocalError LOCAL_FORM_OF_TRANSPORT_REQUIRED = LocalError.of(
      Section.LAND_TRANSPORT, ErrorCode.REQUIRED_FIELD, FieldName.of(Fields.FORM_OF_TRANSPORT));
}
