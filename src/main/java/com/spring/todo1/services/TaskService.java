package com.spring.todo1.services;

import com.spring.todo1.models.Task;

import java.util.List;

public interface TaskService {
    public Task findTaskById(Long id);

   // public Task findByTask(String task);
    public List<Task> findByCompletedTrue();
    public List<Task> findByCompletedFalse();
    public List<Task> findAllTasks();

    public Task createNewTask(Task task);
    public void deleteTask(Task task);
    public Task updateTask(Task task);


}
