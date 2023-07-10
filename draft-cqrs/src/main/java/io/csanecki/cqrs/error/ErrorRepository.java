package io.csanecki.cqrs.error;

import io.csanecki.cqrs.draft.api.DraftId;
import io.csanecki.cqrs.error.web.ErrorResource;
import io.csanecki.cqrs.error.web.ErrorResourceProjection;
import io.csanecki.cqrs.section.Section;
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
      SELECT new io.csanecki.cqrs.error.web.ErrorResource(de.fieldName, de.errorScope, de.errorCode)
      FROM DraftError de
      WHERE de.draftId = :draftId
      """)
  Set<ErrorResource> findProjectionAllByDraftId(@NonNull DraftId draftId);
}
