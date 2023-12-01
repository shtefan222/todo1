package com.spring.todo1.controllers;

import com.spring.todo1.models.Task;
import com.spring.todo1.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;
    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }
    @GetMapping("/all")
    public List<Task> getAllTasks() {
        return taskService.findAllTasks();
    }

    @PostMapping("/create")
    public Task createNewTask(@RequestBody Task task) {
        return taskService.createNewTask(task);
    }

    @PostMapping("/update/{id}")
    public Task updateNewTask(@PathVariable Long id ,@RequestBody Task task) {
        task.setId(id);
        return taskService.updateTask(task);
    }

//    @DeleteMapping("/delete/{id}")
//    public void deleteTask(@PathVariable("id") Long id) {
//        taskService.deleteTask(id);
//    }




}
