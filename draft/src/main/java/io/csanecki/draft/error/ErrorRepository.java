package io.csanecki.draft.error;

import io.csanecki.draft.draft.api.DraftId;
import io.csanecki.draft.error.web.ErrorResource;
import io.csanecki.draft.error.web.ErrorResourceProjection;
import io.csanecki.draft.section.Section;
import lombok.NonNull;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

interface ErrorRepository extends CrudRepository<DraftError, Long>, ErrorResourceProjection {

  void deleteAllByDraftIdAndSection(
      @NonNull DraftId draftId, @NonNull Section section
  );

  long countAllByDraftId(@NonNull DraftId draftId);

  @Override
  @Query("""
      SELECT new io.csanecki.draft.error.web.ErrorResource(de.fieldName, de.errorScope, de.errorCode)
      FROM DraftError de
      WHERE de.draftId = :draftId
      """)
  Set<ErrorResource> findProjectionAllByDraftId(@NonNull DraftId draftId);
}
