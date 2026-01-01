package com.ammarat.spring_todolist.controllers;

import com.ammarat.spring_todolist.entities.TodoList;
import com.ammarat.spring_todolist.services.TodoListService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TodoListController {

    private final TodoListService todoListService;

    public TodoListController(TodoListService todoListService) {
        this.todoListService = todoListService;
    }
    @GetMapping
    public List<TodoList> getAllTodoLists() {
        return todoListService.getAllTodoList();
    }
}
