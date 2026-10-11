package com.touchgrass.infra.adapter.inbound.dto.response;

import com.touchgrass.domain.model.Mission;
import org.springframework.stereotype.Component;

@Component
public class MissionResponseMapper {

    public MissionResponseDto toMissionDto (Mission mission) {
        return new MissionResponseDto(
        mission.getId(),
        mission.getTitle(),
        mission.getMessage(),
        mission.getActivity(),
        mission.getDifficulty(),
        mission.getDurationMinutes(),
        mission.getCompleted(),
        mission.getCreatedAt());
    }

}
