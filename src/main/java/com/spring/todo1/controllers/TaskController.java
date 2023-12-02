package com.spring.todo1.controllers;

import com.spring.todo1.models.Task;
import com.spring.todo1.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    /**
     * Show all tasks
     * @return list of all tasks
     */
    @GetMapping("/all")
    public List<Task> getAllTasks() {
        return taskService.findAllTasks();
    }

    /**
     * Show task by id
     * @return  task by id
     */
    @GetMapping("/{id}")
    public Task findTaskById(@PathVariable Long id) {
        return taskService.findTaskById(id);
    }

    /**
     * Create new task
     * @return new task
     */
    @PostMapping("/create")
    public Task createNewTask(@RequestBody Task task) {
        return taskService.createNewTask(task);
    }

    /**
     * Update task
     * @return updated task
     */
    @PostMapping("/update/{id}")
    public Task updateNewTask(@PathVariable Long id ,@RequestBody Task task) {
        task.setId(id);
        return taskService.updateTask(task);
    }

    /**
     * Show completed tasks
     * @return List of completed tasks
     */
    @GetMapping("/completed")
    public ResponseEntity<List<Task>> getAllCompletedTasks() {
        return ResponseEntity.ok(taskService.findByCompletedTrue());

    }

    /**
     * Show incompleted tasks
     * @return List of completed tasks
     */
    @GetMapping("/incomplete")
    public ResponseEntity<List<Task>> getAllIncompleteTasks() {
        return ResponseEntity.ok(taskService.findByCompletedFalse());
    }

    /**
     * Delete task by id
     */
    @DeleteMapping("delete/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteTaskById(id);
    }

}
