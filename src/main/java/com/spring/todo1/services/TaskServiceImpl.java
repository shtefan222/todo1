package com.spring.todo1.services;

import com.spring.todo1.models.Task;
import com.spring.todo1.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;


@Service
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Task findTaskById(Long id) {
        Optional<Task> optionalTask = taskRepository.findById(id);
        if (optionalTask.isEmpty()) {
            throw new IllegalStateException("Task with id  " + id + " doesn't exist");
        }
        return optionalTask.get();
    }



    @Override
    public List<Task> findByCompletedTrue() {
        return taskRepository.findByCompletedTrue();
    }

    @Override
    public List<Task> findByCompletedFalse() {
        return taskRepository.findByCompletedFalse() ;
    }

    @Override
    public List<Task> findAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Iterable<Task> getAll() {
        return taskRepository.findAll();
    }

    @Override
    public Task createNewTask(Task task) {
        if (task.getId() == null) {
            task.setCreatedAt(Instant.now());
        }
        task.setUpdatedAt(Instant.now());
        return taskRepository.save(task);
    }


    @Override
    public void deleteTaskById(Long id) {
        taskRepository.deleteById(id);
    }

    @Override
    public Task updateTask(Task task) {
        return taskRepository.save(task);
    }



    public List<Task> getSortedTasks() {
        return taskRepository.findAllByOrderByCreatedAtAsc();
    }
}
