package io.csanecki.cqrs.tripdestination.command;

import jakarta.annotation.Nullable;

public record UpdateDestinationCommand(@Nullable String destination) {
}
