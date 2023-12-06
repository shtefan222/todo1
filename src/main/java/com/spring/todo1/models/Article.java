package com.spring.todo1.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Article {
    @Id
    @GeneratedValue
    private Long id;

    private String articleTitle;

    private String articleLink;

    @ManyToOne
    private TodoUser todoUser;


    /**
     *
     */
    @ManyToOne
    @JoinColumn(name = "task_id")
    private Task task;

}
