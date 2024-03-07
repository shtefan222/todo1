package com.spring.todo1.controllers;

import com.spring.todo1.models.Task;
import com.spring.todo1.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.Instant;
import java.util.List;

@Controller


public class TaskController {
    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    /**
     * Adding a new task through a service for handling business logic
     */
    @GetMapping("/")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("tasks", taskService.getAll());
        return modelAndView;
    }


    /**
     * Returning a list of all tasks in JSON format (via @ResponseBody)
     */
    @GetMapping("/all")
    @ResponseBody
    public List<Task> getAllTasks() {
        return taskService.findAllTasks();
    }

    /**
     * Creating a new task with description, creation and update dates, and "not completed" status
     */
    @PostMapping("/addTask")
    public String addTask(@RequestParam("taskDescription") String description) {
        Task newTask = new Task();
        newTask.setTask(description);
        newTask.setCreatedAt(Instant.now());
        newTask.setUpdatedAt(Instant.now());
        newTask.setCompleted(false);

        taskService.createNewTask(newTask);


        return "redirect:/";
    }

    /**
     * Deleting a task by its identifier through the service
     */
    @GetMapping("/deleteTask/{id}")
    public String deleteTask(@PathVariable Long id) {
        taskService.deleteTaskById(id);
        return "redirect:/";
    }


    /**
     * Show task by id
     *
     * @return task by id
     */
    @GetMapping("/{id}")
    @ResponseBody
    public Task findTaskById(@PathVariable Long id) {
        return taskService.findTaskById(id);
    }
//

    /**
     * Create new task
     *
     * @return new task
     */
    @PostMapping("/create")
    @ResponseBody
    public Task createNewTask(@RequestBody Task task) {
        return taskService.createNewTask(task);
    }

    /**
     * Update task
     *
     * @return updated task
     */
    @PostMapping("/update/{id}")
    @ResponseBody
    public Task updateNewTask(@PathVariable Long id, @RequestBody Task task) {
        task.setId(id);
        return taskService.updateTask(task);
    }

    /**
     * Show completed tasks
     *
     * @return List of completed tasks
     */
    @GetMapping("/completed")
    @ResponseBody
    public ResponseEntity<List<Task>> getAllCompletedTasks() {
        return ResponseEntity.ok(taskService.findByCompletedTrue());

    }

    /**
     * Show incomplete tasks
     *
     * @return List of completed tasks
     */
    @GetMapping("/incomplete")
    @ResponseBody
    public ResponseEntity<List<Task>> getAllIncompleteTasks() {
        return ResponseEntity.ok(taskService.findByCompletedFalse());
    }

    /**
     * Delete task by id
     */
    @DeleteMapping("delete/{id}")
    @ResponseBody
    public void deleteTaskItem(@PathVariable Long id) {
        taskService.deleteTaskById(id);
    }

    // New
    @GetMapping("tasks/sorted")
    @ResponseBody
    public List<Task> getSortedTasks() {
        return taskService.getSortedTasks();
    }
}
