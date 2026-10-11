package com.touchgrass.domain.port;

import com.touchgrass.domain.model.Mission;

import java.util.Optional;
import java.util.UUID;

public interface MissionRepository {

    Mission save (Mission mission);

    Optional <Mission> findById (UUID id);


}
