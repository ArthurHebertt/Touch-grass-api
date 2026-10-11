package com.touchgrass.application;

import com.touchgrass.application.Exceptions.MissionNotFoundException;
import com.touchgrass.domain.model.Mission;
import com.touchgrass.domain.port.MissionRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class GetMissionByIdService {

    private final MissionRepository missionRepository;

    public GetMissionByIdService(MissionRepository missionRepository) {
        this.missionRepository = missionRepository;
    }

    public Mission findMission (UUID id) {
        return missionRepository.findById(id).orElseThrow(()-> new MissionNotFoundException ("Mission not found"));
    }
}
