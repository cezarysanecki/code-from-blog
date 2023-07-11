package io.csanecki.draft.landtransport.command;

import jakarta.annotation.Nullable;

public record UpdateFormOfTransportCommand(@Nullable String formOfTransport) {
}
