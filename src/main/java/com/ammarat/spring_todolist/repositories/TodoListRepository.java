package com.ammarat.spring_todolist.repositories;

import com.ammarat.spring_todolist.entities.TodoList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoListRepository extends JpaRepository<TodoList,Integer> {
    List<TodoList> findAllByOrderByIdDesc();
}
