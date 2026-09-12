package com.caltal;

import java.util.ArrayList;
import java.util.List;

public class TaskRepository {
    private final List<Task> tasks = new ArrayList<>();

    public void save(Task task){
        tasks.add(task);
    }

    public List<Task> findAll(){
        return new ArrayList<>(tasks);
    }
}
