package com.caltal;

// import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        TaskRepository repository = new TaskRepository();
        TaskService service = new TaskService(repository);

        service.addTask(new Task("buy milk", 53.7960, -1.5450, 200));
        service.addTask(new Task("gym", 53.8100, -1.5600, 100));
        service.addTask(new Task("dentist", 53.7990, -1.5480, 150));

        List<Task> nearby = service.findNearbyTasks(53.7961, -1.5451);

        for (Task task : nearby) {
            System.out.println("Nearby: " + task.getName());
        }
    }

}