package io.csanecki.draft.landtransport;

import io.csanecki.draft.draft.api.DraftId;
import io.csanecki.draft.landtransport.web.LandTransportResource;
import io.csanecki.draft.landtransport.web.LandTransportResourceProjection;
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
            SELECT new io.csanecki.draft.landtransport.web.LandTransportResource(lt.formOfTransport)
            FROM LandTransport lt
            WHERE lt.draftId = :draftId
            """, LandTransportResource.class)
        .setParameter("draftId", draftId)
        .getSingleResult();
  }
}
