package com.spring.todo1.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

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

    private ArticleType articleType;

   // @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date date;

    private String status;

    @ManyToOne
    private TodoUser todoUser;


    /**
     *
     */
    @ManyToOne
    @JoinColumn(name = "task_id")
    private Task task;

}
