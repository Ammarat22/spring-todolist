package com.ammarat.spring_todolist.services;

import com.ammarat.spring_todolist.entities.TodoList;
import com.ammarat.spring_todolist.repositories.TodoListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class TodoListService implements TodoListServiceImpl{

private final TodoListRepository todoListRepository;

    public TodoListService (TodoListRepository todoListRepository) {
    this.todoListRepository = todoListRepository;
}
@Override
    public List<TodoList> getAllTodoList() {
        return todoListRepository.findAll();
    }
@Override
public TodoList createTodoList(TodoList todoList) {
        return todoListRepository.save(todoList);
}
}
