package com.touchgrass.infra.adapter.inbound.dto.response;

import java.time.Instant;
import java.util.UUID;

public record MissionResponseDto(
        UUID id,
        String title,
        String message,
        String activity,
        com.touchgrass.domain.model.Difficulty difficulty, int durationMinutes,
        boolean completed,
        Instant createdAt
) {


}
