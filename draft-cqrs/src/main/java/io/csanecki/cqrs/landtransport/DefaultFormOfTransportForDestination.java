package io.csanecki.cqrs.landtransport;

import io.csanecki.cqrs.landtransport.api.FormOfTransport;
import io.csanecki.cqrs.tripdestination.api.Country;
import lombok.NonNull;

import java.util.Optional;

public interface DefaultFormOfTransportForDestination {

  Optional<FormOfTransport> findFor(
      @NonNull Country destination
  );

}
