package com.spring.todo1.services;

import com.spring.todo1.models.TodoUser;

import java.util.List;

public interface UserService {

    public List<TodoUser> getAllUsers();
    public Iterable<TodoUser> getAll();
    void deleteTaskById(Long id);

    TodoUser createNewUser(TodoUser user);
}

