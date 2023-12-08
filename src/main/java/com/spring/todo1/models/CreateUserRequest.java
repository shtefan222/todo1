package com.spring.todo1.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserRequest {

    private String username;
    private String task;
    private String articleTitle;
    private String articleLink;


}