package com.caltal;

import java.util.List;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TaskServiceTest {

    @Test
    void returnsOnlyTasksWithinRange() {
        TaskService service = new TaskService();
        service.addTask(new Task("buy milk", 53.7960, -1.5450, 200));
        service.addTask(new Task("gym", 53.8100, -1.5600, 100));

        List<Task> nearby = service.findNearbyTasks(53.7961, -1.5451);

        assertEquals(1, nearby.size());
        assertEquals("buy milk", nearby.get(0).getName());
    }

    @Test
    void excludesCompletedTasksFromResults() {
        TaskService service = new TaskService();

        Task done = new Task("posted letter", 53.7960, -1.5450, 200);
        done.markComplete();
        service.addTask(done);

        List<Task> nearby = service.findNearbyTasks(53.7961, -1.5451);

        assertTrue(nearby.isEmpty());
    }

    @Test
    void returnsEmptyListWhenNothingInRange() {
        TaskService service = new TaskService();
        service.addTask(new Task("get laundry", 53.7960, -1.5450, 200));

        List<Task> nearby = service.findNearbyTasks(51.5074, -0.1278);

        assertTrue(nearby.isEmpty());
    }

    @Test
    void rejectsNullTask() {
        TaskService service = new TaskService();

        assertThrows(IllegalArgumentException.class, () -> service.addTask(null));
    }

    @Test
    void returnedTaskListIsACopy() {
        TaskService service = new TaskService();
        service.addTask(new Task("buy milk", 53.7960, -1.5450, 200));

        service.getAllTasks().clear();

        assertEquals(1, service.getAllTasks().size());
    }
}