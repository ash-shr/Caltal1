package com.caltal;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


class TaskTest {

    @Test
    void createsTaskWithValidValues() {
        Task task = new Task("buy milk", 53.8008, -1.5491, 200);

        assertEquals("buy milk", task.getName());
        assertEquals(200, task.getRadius());
    }

    @Test
    void rejectsLatitudeAboveNinety() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("impossible", 9999, 0, 200);
        });
    }

    @Test
    void marksTaskComplete() {
        Task task = new Task("gym", 53.8100, -1.5600, 100);
        task.markComplete();

        assertTrue(task.isComplete());
    }

    @Test
    void returnsTrueWhenUserIsInsideGeofence() {
        Task task = new Task("gym", 53.8100, -1.5600, 100);
        boolean result = task.isWithinRange(53.8101, -1.5600);
        assertTrue(result);
    }

    @Test
    void returnsFalseWhenUserIsOutsideGeofence() {
        Task task = new Task("gym", 53.8100, -1.5600, 100);
        boolean result = task.isWithinRange(53.900, -1.5600);
        assertFalse(result);
    }

}