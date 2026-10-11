package com.touchgrass.infra.adapter.inbound;

import com.touchgrass.application.Exceptions.MissionNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MissionNotFoundException.class)
    public ResponseEntity<String> missionNotFoundHandler (MissionNotFoundException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Mission not found");
    }



}
