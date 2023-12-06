package com.spring.todo1.services;

import com.spring.todo1.models.TodoUser;
import com.spring.todo1.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public List<TodoUser> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Iterable<TodoUser> getAll() {
        return userRepository.findAll();
    }

    @Override
    public void deleteTaskById(Long id) {

    }

    @Override
    public TodoUser createNewUser(TodoUser user) {
        return userRepository.save(user);
    }
}
