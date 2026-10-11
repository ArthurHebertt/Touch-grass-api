package com.touchgrass.application.useCase;

import com.touchgrass.domain.model.Mission;
import com.touchgrass.domain.port.MissionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllMissionsService {

    private final MissionRepository missionRepository;

    public GetAllMissionsService(MissionRepository missionRepository) {
        this.missionRepository = missionRepository;
    }

    public List<Mission> getAllMission () {
       return missionRepository.findAll();
    }

}
