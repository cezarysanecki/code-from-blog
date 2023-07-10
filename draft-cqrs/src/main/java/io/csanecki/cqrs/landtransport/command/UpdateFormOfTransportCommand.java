package io.csanecki.cqrs.landtransport.command;

import io.csanecki.cqrs.landtransport.api.FormOfTransport;
import jakarta.annotation.Nullable;

public record UpdateFormOfTransportCommand(@Nullable FormOfTransport formOfTransport) {
}
