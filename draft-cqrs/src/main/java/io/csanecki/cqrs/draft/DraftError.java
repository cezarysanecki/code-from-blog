package io.csanecki.cqrs.draft;

import io.csanecki.cqrs.error.api.ErrorCode;
import io.csanecki.cqrs.error.api.GlobalError;
import io.csanecki.cqrs.section.Section;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
final class DraftError {

  static GlobalError GLOBAL_DRAFT_CANNOT_BE_ACCEPTED = GlobalError.of(
      Section.ROOT, ErrorCode.of("DRAFT_CANNOT_BE_ACCEPTED"));
  static GlobalError GLOBAL_DRAFT_IS_NOT_EDITABLE = GlobalError.of(
      Section.ROOT, ErrorCode.UNEDITABLE);

}