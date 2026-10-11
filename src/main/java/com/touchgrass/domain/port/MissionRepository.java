package com.touchgrass.domain.port;

import com.touchgrass.domain.model.Mission;

public interface MissionRepository {

    Mission save (Mission mission);
}
