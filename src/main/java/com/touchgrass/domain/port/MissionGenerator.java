package com.touchgrass.domain.port;

import com.touchgrass.domain.model.Difficulty;
import com.touchgrass.domain.model.GeneratedMissionContent;

public interface MissionGenerator {

    GeneratedMissionContent generate (int maxDurationMinutes, Difficulty difficulty);

}

