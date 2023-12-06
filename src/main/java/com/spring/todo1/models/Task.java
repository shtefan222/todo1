package com.spring.todo1.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Task {
    @Id
    @GeneratedValue
    private Long id;

    private String task;

    private Instant createdAt;
    private Instant updatedAt;

    private Boolean completed;


    @ManyToOne
    private TodoUser todoUser;
    /**
     * When we create task, we can add several articles to it that contain the necessary information
     * for its successful completion
     */
    @OneToMany(mappedBy = "task")
    private List<Article> articleList;

    @Override
    public String toString() {
        return String.format("Task{id=%d, description='%s', isComplete='%s', createdAt='%s', updatedAt='%s'}",
                id, task, completed, createdAt, updatedAt);
    }

}
