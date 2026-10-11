package com.touchgrass.application;

import com.touchgrass.application.Exceptions.MissionNotFoundException;
import com.touchgrass.domain.model.Mission;
import com.touchgrass.domain.port.MissionRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CompleteMissionService {

    private final MissionRepository missionRepository;

    public CompleteMissionService(MissionRepository missionRepository) {
        this.missionRepository = missionRepository;
    }

    public Mission completeMission (UUID id) {
        Mission mission = missionRepository.findById(id).orElseThrow(()-> new MissionNotFoundException ("Mission not found"));

        mission.complete();

        return missionRepository.save(mission);


    }

}
