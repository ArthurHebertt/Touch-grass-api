package com.touchgrass.infra.adapter.outbound.persistence;

import com.touchgrass.domain.model.Mission;
import com.touchgrass.domain.port.MissionRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class MissionPersistenceAdapter implements MissionRepository {

    private final SpringDataMissionRepository springDataMissionRepository;
    private final MissionPersistenceMapper missionPersistenceMapper;

    public MissionPersistenceAdapter(SpringDataMissionRepository springDataMissionRepository, MissionPersistenceMapper missionPersistenceMapper) {
        this.springDataMissionRepository = springDataMissionRepository;
        this.missionPersistenceMapper = missionPersistenceMapper;
    }

    @Override
    public Mission save (Mission mission) {
        MissionJpaEntity entity = missionPersistenceMapper.toEntity(mission);
        MissionJpaEntity savedEntity = springDataMissionRepository.save(entity);
        return missionPersistenceMapper.toMission(savedEntity);

    }

    @Override
    public Optional <Mission> findById (UUID id) {
    Optional <MissionJpaEntity> mission = springDataMissionRepository.findById(id);
    return mission.map(entity -> missionPersistenceMapper.toMission(entity));

    }

}
