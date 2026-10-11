package com.touchgrass.infra.adapter.outbound.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SpringDataMissionRepository extends JpaRepository <MissionJpaEntity, UUID> {
}
