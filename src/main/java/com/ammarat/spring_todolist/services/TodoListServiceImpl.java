package com.ammarat.spring_todolist.services;

import com.ammarat.spring_todolist.dto.TodoListDto;
import com.ammarat.spring_todolist.dto.TodoListReqDto;
import com.ammarat.spring_todolist.entities.TodoList;

import java.util.List;

public interface TodoListServiceImpl {
    List<TodoListDto> getAllTodoLists(String order);

    TodoList getTodoListById(Integer id);
    TodoList createTodoList(TodoListReqDto todoListReqDto);
    TodoList updateTodoList(Integer id, TodoListReqDto todoListReqDto);
    void deleteTodoList(Integer id);
}
