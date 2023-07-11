package io.csanecki.cqrs.landtransport.command;

import jakarta.annotation.Nullable;

public record UpdateFormOfTransportCommand(@Nullable String formOfTransport) {
}
