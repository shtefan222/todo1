package com.spring.todo1.services;

import com.spring.todo1.models.TodoUser;

import java.util.List;

public interface UserService {

    List<TodoUser> getAllUsers();
    Iterable<TodoUser> getAll();
    void deleteTaskById(Long id);

    TodoUser createNewUser(TodoUser user);


    void createUserWithArticleAndTask(String username, String task, String articleTitle, String articleLink);
}

