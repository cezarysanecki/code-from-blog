package io.csanecki.draft.section;

import io.csanecki.draft.draft.api.DraftId;
import lombok.NonNull;

public interface RootSectionAvailability {

  boolean isEditable(@NonNull DraftId draftId);

  SectionAvailability checkAvailability(@NonNull DraftId draftId);

}
