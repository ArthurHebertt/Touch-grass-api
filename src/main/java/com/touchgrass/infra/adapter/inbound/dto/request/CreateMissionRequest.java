package com.touchgrass.infra.adapter.inbound.dto.request;

import com.touchgrass.domain.model.Difficulty;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record CreateMissionRequest(

        @Max(120)
        @Min(5)
        int maxDurationMinutes,

        @NotNull
        Difficulty difficulty

) {
}
