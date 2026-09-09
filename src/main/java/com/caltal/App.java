package com.caltal;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        List<Task> tasks = new ArrayList<>();

        tasks.add(new Task("buy milk", 53.7960, -1.5450, 200));
        tasks.add(new Task("gym", 53.8100, -1.5600, 100));
        tasks.add(new Task("dentist", 53.7990, -1.5480, 150));

        List<Task> nearby = findNearbyTasks(tasks, 53.7961, -1.5451);

        for (Task task : nearby) {
            System.out.println("Nearby: " + task.getName());
        }
    }

    public static List<Task> findNearbyTasks(List<Task> tasks, double userLatitude, double userLongitude) {
        List<Task> nearby = new ArrayList<>();

        for (Task task : tasks) {
            if (!task.isComplete() && task.isWithinRange(userLatitude, userLongitude)) {
                nearby.add(task);
            }
        }
        return nearby;
        

    }
    
}