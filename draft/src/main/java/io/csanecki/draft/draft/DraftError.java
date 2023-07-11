package io.csanecki.draft.draft;

import io.csanecki.draft.error.api.ErrorCode;
import io.csanecki.draft.error.api.GlobalError;
import io.csanecki.draft.section.Section;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
final class DraftError {

  static GlobalError GLOBAL_DRAFT_CANNOT_BE_ACCEPTED = GlobalError.of(
      Section.ROOT, ErrorCode.of("DRAFT_CANNOT_BE_ACCEPTED"));
  static GlobalError GLOBAL_DRAFT_IS_NOT_EDITABLE = GlobalError.of(
      Section.ROOT, ErrorCode.UNEDITABLE);

}
