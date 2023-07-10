package io.csanecki.cqrs.landtransport;

import io.csanecki.cqrs.landtransport.api.FormOfTransport;
import io.csanecki.cqrs.tripdestination.api.Country;
import lombok.NonNull;

public interface DefaultFormOfTransportForDestination {

  FormOfTransport findFor(
      @NonNull Country destination
  );

}
