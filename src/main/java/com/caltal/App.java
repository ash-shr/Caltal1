package com.caltal;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);

    }

    @Bean
    CommandLineRunner seedTasks(TaskService service) {
        return args -> {
            service.addTask(new Task("buy milk", 53.7960, -1.5450, 200));
            service.addTask(new Task("gym", 53.8100, -1.5600, 100));
            service.addTask(new Task("dentist", 53.7990, -1.5480, 150));
        };
    }
}