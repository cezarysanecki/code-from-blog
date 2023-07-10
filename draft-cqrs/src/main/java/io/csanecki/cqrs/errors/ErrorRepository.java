package io.csanecki.cqrs.errors;

import io.csanecki.cqrs.draft.api.DraftId;
import io.csanecki.cqrs.errors.web.ErrorResource;
import io.csanecki.cqrs.errors.web.ErrorResourceProjection;
import lombok.NonNull;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

interface ErrorRepository extends CrudRepository<DraftError, Long>, ErrorResourceProjection {

  void deleteAllByDraftId(
      @NonNull DraftId draftId
  );

  @Override
  @Query("""
      SELECT new io.csanecki.cqrs.errors.web.ErrorResource(de.fieldName, de.errorScope, de.errorCode)
      FROM DraftError de
      WHERE de.draftId = :draftId
      """)
  Set<ErrorResource> findProjectionAllByDraftId(@NonNull DraftId draftId);
}
