package com.touchgrass.application.useCase;

import com.touchgrass.domain.model.Difficulty;
import com.touchgrass.domain.model.GeneratedMissionContent;
import com.touchgrass.domain.model.Mission;
import com.touchgrass.domain.port.MissionGenerator;
import com.touchgrass.domain.port.MissionRepository;
import org.springframework.stereotype.Service;

@Service
public class CreateMissionService {

    private MissionGenerator missionGenerator;
    private MissionRepository missionRepository;

    public CreateMissionService(MissionGenerator missionGenerator, MissionRepository missionRepository) {
        this.missionGenerator = missionGenerator;
        this.missionRepository = missionRepository;
    }

    public Mission createMission (int maxDuration, Difficulty difficulty) {

        if (maxDuration <5 || maxDuration >120) {
            throw new IllegalArgumentException("mission duration must respect the limit");
        }

        GeneratedMissionContent generatedMissionContent = missionGenerator.generate(maxDuration, difficulty);

        Mission mission = new Mission(
                generatedMissionContent.getTitle(),
                generatedMissionContent.getMessage(),
                generatedMissionContent.getActivity(),
                generatedMissionContent.getDurationMinutes(),
                generatedMissionContent.getDifficulty());

        if (mission.getDurationMinutes() > maxDuration) {
            throw new IllegalArgumentException("mission duration must respect the limit");
        }

        return missionRepository.save(mission);


    }

}
