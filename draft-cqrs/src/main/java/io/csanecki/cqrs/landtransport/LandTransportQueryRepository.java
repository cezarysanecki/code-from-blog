package io.csanecki.cqrs.landtransport;

import io.csanecki.cqrs.draft.api.DraftId;
import io.csanecki.cqrs.landtransport.web.LandTransportResource;
import io.csanecki.cqrs.landtransport.web.LandTransportResourceProjection;
import jakarta.persistence.EntityManager;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
class LandTransportQueryRepository implements LandTransportResourceProjection {

  private final EntityManager entityManager;

  @Override
  public LandTransportResource findProjectionByDraftId(@NonNull DraftId draftId) {
    return entityManager.createQuery("""
            SELECT new io.csanecki.cqrs.landtransport.web.LandTransportResource(lt.formOfTransport)
            FROM LandTransport lt
            WHERE lt.draftId = :draftId
            """, LandTransportResource.class)
        .setParameter("draftId", draftId)
        .getSingleResult();
  }
}
