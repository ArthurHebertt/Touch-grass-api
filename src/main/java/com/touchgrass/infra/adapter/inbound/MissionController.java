package com.touchgrass.infra.adapter.inbound;

import com.touchgrass.application.useCase.CompleteMissionService;
import com.touchgrass.application.useCase.CreateMissionService;
import com.touchgrass.application.useCase.GetAllMissionsService;
import com.touchgrass.application.useCase.GetMissionByIdService;
import com.touchgrass.domain.model.Mission;
import com.touchgrass.infra.adapter.inbound.dto.request.CreateMissionRequest;
import com.touchgrass.infra.adapter.inbound.dto.response.MissionResponseDto;
import com.touchgrass.infra.adapter.inbound.dto.response.MissionResponseMapper;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/missions")
public class MissionController {

    private final MissionResponseMapper missionResponseMapper;

    private final CreateMissionService createMissionService;

    private final GetMissionByIdService getMissionByIdService;

    private final CompleteMissionService completeMissionService;

    private final GetAllMissionsService getAllMissionsService;

    public MissionController(MissionResponseMapper missionResponseMapper, CreateMissionService createMissionService, GetMissionByIdService getMissionByIdService, CompleteMissionService completeMissionService, GetAllMissionsService getAllMissionsService) {
        this.missionResponseMapper = missionResponseMapper;
        this.createMissionService = createMissionService;
        this.getMissionByIdService = getMissionByIdService;
        this.completeMissionService = completeMissionService;
        this.getAllMissionsService = getAllMissionsService;
    }

    @PostMapping
    public ResponseEntity<MissionResponseDto> createMission (@RequestBody @Valid CreateMissionRequest createMissionRequest) {
        Mission generatedMission = createMissionService.createMission(createMissionRequest.maxDurationMinutes(), createMissionRequest.difficulty());
        MissionResponseDto result = missionResponseMapper.toMissionDto(generatedMission);
        return new ResponseEntity<> (result, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MissionResponseDto> findMission (@PathVariable UUID id) {
        Mission mission = getMissionByIdService.findMission(id);
        return ResponseEntity.ok(missionResponseMapper.toMissionDto(mission));
    }

    @PatchMapping("/{id}/completion")
    public ResponseEntity<MissionResponseDto> completeMission (@PathVariable UUID id) {
        Mission mission = completeMissionService.completeMission(id);
        return ResponseEntity.ok(missionResponseMapper.toMissionDto(mission));
    }

    @GetMapping
    public ResponseEntity<List<MissionResponseDto>> findAllMissions () {
        List<Mission> missions = getAllMissionsService.getAllMission();
        return ResponseEntity.ok(missions.stream()
                .map(missionResponseMapper::toMissionDto)
                .toList());
    }

}
