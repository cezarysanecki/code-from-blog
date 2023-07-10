package io.csanecki.cqrs.section;

import io.csanecki.cqrs.draft.api.DraftId;
import lombok.NonNull;

public interface RootSectionAvailability {

  boolean isEditable(@NonNull DraftId draftId);

  SectionAvailability checkAvailability(@NonNull DraftId draftId);

}
