package com.touchgrass.domain.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Null;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;

public class MissionTest {

    Instant createdAt = Instant.parse("2026-08-31T20:00:00Z");

    private Mission mission;

    @BeforeEach
    void setup() {
        mission = new Mission(
                "test",
                "this is a test",
                "test",
                10,
                Difficulty.EASY);

    }

    @Test
    void shouldReturnFalseWhenMissionIsCreated() {

        boolean result = mission.isComplete();

        assertFalse(result);

    }

    @Test
    void shouldReturnTrueWhenMissionIsComplete() {

        mission.complete();

        boolean result = mission.isComplete();

        assertTrue(result);

    }

    @Test
    void shouldReturnTrueWhenMissionIsCompleteTwice() {

        mission.complete();
        mission.complete();

        boolean result = mission.isComplete();

        assertTrue(result);

    }

    @Test
    void shouldThrowExceptionWhenDurationIsBelow0() {

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new Mission("test",
                        "this is a test",
                        "test",
                        0,
                        Difficulty.EASY)

        );

        assertEquals("must be greater than zero", exception.getMessage());

    }

    @Test
    void shouldThrowExceptionWhenTitleIsNull() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new Mission(null,
                        "this is a test",
                        "test",
                        10,
                        Difficulty.EASY)

        );

        assertEquals("must not be blank or null", exception.getMessage());

    }

    @Test
    void shouldThrowExceptionWhenTitleIsBlank() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new Mission(" ",
                        "this is a test",
                        "test",
                        10,
                        Difficulty.EASY)

        );

        assertEquals("must not be blank or null", exception.getMessage());


    }

}
