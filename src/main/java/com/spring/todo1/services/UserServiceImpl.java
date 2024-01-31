package com.spring.todo1.services;

import com.spring.todo1.models.Article;
import com.spring.todo1.models.Task;
import com.spring.todo1.models.TodoUser;
import com.spring.todo1.repositories.ArticleRepository;
import com.spring.todo1.repositories.TaskRepository;
import com.spring.todo1.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;

    private final  TaskRepository taskRepository;


    private final ArticleRepository articleRepository;
        @Autowired
    public UserServiceImpl(UserRepository userRepository, TaskRepository taskRepository, ArticleRepository articleRepository) {
        this.userRepository = userRepository;
        this.taskRepository = taskRepository;
        this.articleRepository = articleRepository;
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

    @Transactional
    public void createUserWithArticleAndTask(String username, String task, String articleTitle, String articleLink) {
        TodoUser user = new TodoUser();
        user.setUsername(username);

        Task newTask = new Task();
        newTask.setTask(task);
        newTask.setTodoUser(user);
        taskRepository.save(newTask);

        Article newArticle = new Article();
        newArticle.setArticleTitle(articleTitle);
        newArticle.setArticleLink(articleLink);
        newArticle.setTask(newTask);
        articleRepository.save(newArticle);

        user.setTasks(Collections.singletonList(newTask));
        user.setArticles(Collections.singletonList(newArticle));
        userRepository.save(user);
    }


}
