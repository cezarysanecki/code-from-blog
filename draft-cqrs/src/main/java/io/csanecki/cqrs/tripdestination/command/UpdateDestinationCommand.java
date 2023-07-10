package io.csanecki.cqrs.tripdestination.command;

import io.csanecki.cqrs.tripdestination.api.Country;
import jakarta.annotation.Nullable;

public record UpdateDestinationCommand(@Nullable Country destination) {
}
