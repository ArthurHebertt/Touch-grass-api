package com.touchgrass.infra.adapter.outbound.persistence;

import com.touchgrass.domain.model.Difficulty;
import jakarta.persistence.*;

import java.time.Instant;
import java.util.UUID;


@Entity
@Table
public class MissionJpaEntity {

    @Id
    private UUID id;

    private String title;

    @Column(columnDefinition = "TEXT")
    private String message;

    private String activity;

    private int durationMinutes;

    @Enumerated(EnumType.STRING)
    private Difficulty difficulty;

    private boolean completed;

    private Instant createdAt;

    public MissionJpaEntity() {
    }

    public MissionJpaEntity(UUID id, String title, String message, String activity, int durationMinutes, Difficulty difficulty, boolean completed, Instant createdAt) {
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
