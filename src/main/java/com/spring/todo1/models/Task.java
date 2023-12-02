package com.spring.todo1.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task {
    @Id
    @GeneratedValue
    private Long id;

    private String task;

    private boolean completed;
    /**
     * When we create task, we can add several articles to it that contain the necessary information
     * for its successful completion
     */
    @OneToMany(mappedBy = "task")
    private List<Article> articleList;



}
