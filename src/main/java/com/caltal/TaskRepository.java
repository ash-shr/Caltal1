package com.caltal;

// import java.util.ArrayList;
import java.util.List;

public interface TaskRepository {
    void save(Task task);
    List<Task> findAll();
}
