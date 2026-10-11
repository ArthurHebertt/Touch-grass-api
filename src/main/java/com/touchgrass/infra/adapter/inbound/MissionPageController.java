package com.touchgrass.infra.adapter.inbound;

import com.touchgrass.application.useCase.CompleteMissionService;
import com.touchgrass.application.useCase.CreateMissionService;
import org.springframework.ui.Model;
import com.touchgrass.application.useCase.GetAllMissionsService;
import com.touchgrass.domain.model.Difficulty;
import com.touchgrass.domain.model.Mission;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@Controller
public class MissionPageController {

    private final GetAllMissionsService getAllMissionsService;

    private final CreateMissionService createMissionService;

    private final CompleteMissionService completeMissionService;

    public MissionPageController(GetAllMissionsService getAllMissionsService, CreateMissionService createMissionService, CompleteMissionService completeMissionService) {
        this.getAllMissionsService = getAllMissionsService;
        this.createMissionService = createMissionService;
        this.completeMissionService = completeMissionService;
    }

    @GetMapping ("/missions")
    public String allMissions (Model model) {
        List<Mission> missions = getAllMissionsService.getAllMission();
        model.addAttribute("missions", missions);
        model.addAttribute("difficulties", Difficulty.values());
        return "index";

    }

    @PostMapping("/missions")
    public String createMission (
            @RequestParam ("maxDurationMinutes") int maxDurationMinutes,
            @RequestParam ("difficulty") Difficulty difficulty, Model model) {

        createMissionService.createMission(maxDurationMinutes,difficulty);

        model.addAttribute("missions", getAllMissionsService.getAllMission());
        model.addAttribute("difficulties", Difficulty.values());

        return "index";
    }

    @PostMapping("/missions/{id}/completion")
    public String completeMission (@PathVariable UUID id, Model model){
        completeMissionService.completeMission(id);
        model.addAttribute("missions", getAllMissionsService.getAllMission());
        model.addAttribute("difficulties", Difficulty.values());
        return "index";
    }

}