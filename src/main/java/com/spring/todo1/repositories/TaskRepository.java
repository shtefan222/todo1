package com.spring.todo1.repositories;

import com.spring.todo1.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task,Long> {
    List<Task> findByCompletedTrue();
    List<Task> findByCompletedFalse();

    List<Task> findAllByOrderByCreatedAtAsc();

}
