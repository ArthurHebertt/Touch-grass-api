package com.touchgrass.domain.model;

import java.time.Instant;
import java.util.UUID;


public class Mission {

    private UUID id;
    private String title;
    private String message;
    private String activity;
    private int durationMinutes;
    private Difficulty difficulty;
    private boolean completed;
    private Instant createdAt;

    public void complete() {
        this.completed = true;
    }

    public boolean isComplete() {
        return completed;
    }

    public Mission(String title, String message, String activity, int durationMinutes, Difficulty difficulty) {
       this.id = UUID.randomUUID();

        if (title == null ||title.isBlank()) {
            throw new IllegalArgumentException("must not be blank or null");
        } this.title = title;

        if (message == null ||message.isBlank()) {
            throw new IllegalArgumentException("must not be blank or null");
        } this.message = message;

        if (activity == null ||activity.isBlank()) {
            throw new IllegalArgumentException("must not be blank or null");
        } this.activity = activity;

        if (durationMinutes <= 0) {
            throw new IllegalArgumentException("must be greater than zero");
        } this.durationMinutes = durationMinutes;

        if (difficulty == null) {
            throw new IllegalArgumentException("must not be blank or null");
        } this.difficulty = difficulty;

        this.completed = false;

        this.createdAt = Instant.now();
    }

    public Mission(UUID id, String title, String message, String activity, int durationMinutes, Difficulty difficulty, boolean completed, Instant createdAt) {
        this.id = id;
        this.title = title;
        this.message = message;
        this.activity = activity;
        this.durationMinutes = durationMinutes;
        this.difficulty = difficulty;
        this.completed = completed;
        this.createdAt = createdAt;
    }

    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getMessage() {
        return message;
    }

    public String getActivity() {
        return activity;
    }

    public int getDurationMinutes() {
        return durationMinutes;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public boolean getCompleted() {
        return completed;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }
}
