package com.caltal;

import java.util.ArrayList;
import java.util.List;

public class TaskService {
    private final List<Task> tasks = new ArrayList<>();

    public void addTask(Task task){
        if (task == null){
            throw new IllegalArgumentException("Task must not be null");

        }
        tasks.add(task);
    }
    public List<Task> getAllTasks(){
        return new ArrayList<>(tasks);
    }
    public List<Task> findNearbyTasks(double userLatitude, double userLongitude){
        List<Task> nearby = new ArrayList<>();
        for (Task task: tasks){
            if (!task.isComplete() && task.isWithinRange(userLatitude, userLongitude)){
                nearby.add(task);
            }
        }
        return nearby;
    }
}
