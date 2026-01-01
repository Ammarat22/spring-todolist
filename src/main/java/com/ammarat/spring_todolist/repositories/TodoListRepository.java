package com.ammarat.spring_todolist.repositories;

import com.ammarat.spring_todolist.entities.TodoList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoListRepository extends JpaRepository<TodoList,Integer> {
}
