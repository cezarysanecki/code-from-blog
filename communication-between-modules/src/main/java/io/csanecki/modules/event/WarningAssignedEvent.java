package io.csanecki.modules.event;

import io.csanecki.modules.utils.vo.CitizenId;

public record WarningAssignedEvent(CitizenId citizenId) {
}
