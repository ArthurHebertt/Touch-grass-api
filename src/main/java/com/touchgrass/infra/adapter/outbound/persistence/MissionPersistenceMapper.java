package com.touchgrass.infra.adapter.outbound.persistence;

import com.touchgrass.domain.model.Mission;
import org.springframework.stereotype.Component;

@Component
public class MissionPersistenceMapper {

    public MissionJpaEntity toEntity(Mission mission) {
        return new MissionJpaEntity(
                mission.getId(),
                mission.getTitle(),
                mission.getMessage(),
                mission.getActivity(),
                mission.getDurationMinutes(),
                mission.getDifficulty(),
                mission.getCompleted(),
                mission.getCreatedAt());

    }

    public Mission toMission(MissionJpaEntity entity) {
        return new Mission(
                entity.getId(),
                entity.getTitle(),
                entity.getMessage(),
                entity.getActivity(),
                entity.getDurationMinutes(),
                entity.getDifficulty(),
                entity.getCompleted(),
                entity.getCreatedAt()
        );
    }
}