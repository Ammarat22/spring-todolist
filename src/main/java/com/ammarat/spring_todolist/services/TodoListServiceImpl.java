package com.ammarat.spring_todolist.services;

import com.ammarat.spring_todolist.dto.TodoListDto;
import com.ammarat.spring_todolist.dto.TodoListReqDto;

import java.util.List;

public interface TodoListServiceImpl {
    List<TodoListDto> getAllTodoLists(String order);
    TodoListDto getTodoListById(Integer id);
    TodoListDto createTodoList(TodoListReqDto todoListReqDto);
    TodoListDto updateTodoList(Integer id, TodoListReqDto todoListReqDto);
    void deleteTodoList(Integer id);
}
