package com.spring.todo1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * At the moment, the following functionality is present:
 * - creating a task, updating and deleting it
 * - output of all tasks, or separately completed and incomplete
 * - search for tasks by id
 * - adding, updating and deleting articles
 * - output of all articles
 * - add html with thymeleaf, and now we can create and delete task in browser
 * It is planned to add:
 * - a habit tracker that will allow you to mark whether a task has been completed or not every day
 * - tags, so that when creating a task or habit, articles are automatically pulled to this task or habit
 * - basic logic for tasks: the ability to create categories, prioritize and sort.
 */
@SpringBootApplication
public class Todo1Application {

	public static void main(String[] args) {
		SpringApplication.run(Todo1Application.class, args);
	}

}
