package com.touchgrass.domain.model;

public class GeneratedMissionContent {

    private String title;
    private String message;
    private String activity;
    private int durationMinutes;
    private Difficulty difficulty;

    public GeneratedMissionContent(String title, String message, String activity, int durationMinutes, Difficulty difficulty) {
        this.title = title;
        this.message = message;
        this.activity = activity;
        this.durationMinutes = durationMinutes;
        this.difficulty = difficulty;
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
}

