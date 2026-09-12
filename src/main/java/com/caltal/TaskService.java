package com.caltal;

import java.util.ArrayList;
import java.util.List;

public class TaskService {

    private final TaskRepository repository;

    public TaskService(TaskRepository repository) {
        if (repository == null) {
            throw new IllegalArgumentException("Repository must not be null");
        }
        this.repository = repository;
    }

    public void addTask(Task task) {
        if (task == null) {
            throw new IllegalArgumentException("Task must not be null");
        }
        repository.save(task);
    }

    public List<Task> getAllTasks() {
        return repository.findAll();
    }

    public List<Task> findNearbyTasks(double userLatitude, double userLongitude) {
        List<Task> nearby = new ArrayList<>();

        for (Task task : repository.findAll()) {
            if (!task.isComplete() && task.isWithinRange(userLatitude, userLongitude)) {
                nearby.add(task);
            }
        }

        return nearby;
    }
}