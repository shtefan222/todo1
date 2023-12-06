package com.spring.todo1.repositories;

import com.spring.todo1.models.TodoUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<TodoUser,Long> {

}
