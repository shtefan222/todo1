package com.spring.todo1.controllers;

import com.spring.todo1.models.CreateUserRequest;
import com.spring.todo1.models.TodoUser;
import com.spring.todo1.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("user-details");
        modelAndView.addObject("user", userService.getAll());
        return modelAndView;
    }

    @GetMapping("/users/all")
    @ResponseBody
    public List<TodoUser>  getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/users/create-from-web")
    @ResponseBody
    public TodoUser createUser(@RequestBody TodoUser user) {

        return userService.createNewUser(user);
    }

    @PostMapping("/users/create")
    @ResponseBody
    public ResponseEntity<Void> createUser(@RequestBody CreateUserRequest request) {
        userService.createUserWithArticleAndTask(request.getUsername(), request.getTask(), request.getArticleTitle(), request.getArticleLink());
        return ResponseEntity.ok().build();
    }
}
