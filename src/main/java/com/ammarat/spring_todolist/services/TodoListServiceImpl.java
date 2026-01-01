package com.ammarat.spring_todolist.services;

import com.ammarat.spring_todolist.entities.TodoList;

import java.util.List;

public interface TodoListServiceImpl {
    List<TodoList> getAllTodoList();
    TodoList createTodoList(TodoList todoList);
}
