package com.ammarat.spring_todolist.controllers;

import com.ammarat.spring_todolist.dto.TodoListDto;
import com.ammarat.spring_todolist.entities.TodoList;
import com.ammarat.spring_todolist.services.TodoListService;
import org.springframework.boot.jdbc.metadata.TomcatDataSourcePoolMetadata;
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
    public List<TodoListDto> getAllTodoLists(@RequestParam(value = "order", required = false) String order) {
        return todoListService.getAllTodoLists(order);
    }

   @PostMapping
   public TodoListDto createTodoList(@RequestBody TodoListDto todoListDto) {
        return todoListService.createTodoList(todoListDto);
    }

    @PutMapping("/{id}")
    public TodoListDto updateTodoList(@PathVariable Integer id, @RequestBody TodoListDto todoListDto) {
        return todoListService.updateTodoList(id, todoListDto);
    }

    @DeleteMapping("/{id}")
    public void deleteTodoList(@PathVariable Integer id) {
        todoListService.deleteTodoList(id);
    }
}
