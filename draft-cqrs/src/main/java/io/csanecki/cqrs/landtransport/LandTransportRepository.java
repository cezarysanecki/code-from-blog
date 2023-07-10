package io.csanecki.cqrs.landtransport;

import io.csanecki.cqrs.draft.DraftId;
import io.csanecki.cqrs.landtransport.api.LandTransportNotFoundException;
import io.csanecki.cqrs.landtransport.web.LandTransportResourceProjection;
import io.csanecki.cqrs.landtransport.web.LandTransportResource;
import lombok.NonNull;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

interface LandTransportRepository extends CrudRepository<LandTransport, Long>, LandTransportResourceProjection {

  Optional<LandTransport> findByDraftId(
      @NonNull DraftId draftId
  );

  default LandTransport findByDraftIdForce(
      @NonNull DraftId draftId
  ) {
    return findByDraftId(draftId)
        .orElseThrow(() -> new LandTransportNotFoundException(draftId));
  }

  @Override
  @Query("""
      SELECT new io.csanecki.cqrs.landtransport.web.LandTransportResource(lt.draftId, lt.formOfTransport)
      FROM LandTransport lt
      WHERE lt.draftId = :draftId
      """)
  LandTransportResource findProjectionByDraftId(@NonNull DraftId draftId);
}
