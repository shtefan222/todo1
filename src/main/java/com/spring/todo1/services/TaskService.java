package com.spring.todo1.services;

import com.spring.todo1.models.Task;

import java.util.List;

public interface TaskService {
    Task findTaskById(Long id);


    List<Task> findByCompletedTrue();
    List<Task> findByCompletedFalse();
    List<Task> findAllTasks();

    public Iterable<Task> getAll();

    Task createNewTask(Task task);

    void deleteTaskById(Long id);
    Task updateTask(Task task);


}
