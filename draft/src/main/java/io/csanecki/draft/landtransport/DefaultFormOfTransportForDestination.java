package io.csanecki.draft.landtransport;

import io.csanecki.draft.landtransport.api.FormOfTransport;
import io.csanecki.draft.tripdestination.api.Country;
import lombok.NonNull;

import java.util.Optional;

public interface DefaultFormOfTransportForDestination {

  Optional<FormOfTransport> findFor(
      @NonNull Country destination
  );

}
