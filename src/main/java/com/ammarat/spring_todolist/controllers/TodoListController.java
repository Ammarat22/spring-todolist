package com.ammarat.spring_todolist.controllers;

import com.ammarat.spring_todolist.entities.TodoList;
import com.ammarat.spring_todolist.services.TodoListService;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todolist")
public class TodoListController {

    private final TodoListService todoListService;

    public TodoListController(TodoListService todoListService) {
        this.todoListService = todoListService;
    }

    @GetMapping
    public List<TodoList> getAllTodoLists() {
        return todoListService.getAllTodoList();
    }

   @PostMapping
   public TodoList createTodoList(@RequestBody TodoList todoList) {
        return todoListService.createTodoList(todoList);
    }
}
