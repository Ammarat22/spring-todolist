package com.ammarat.spring_todolist.controllers;

import com.ammarat.spring_todolist.dto.TodoListDto;
import com.ammarat.spring_todolist.dto.TodoListReqDto;
import com.ammarat.spring_todolist.services.TodoListService;
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
    public TodoListDto createTodoList(
            @RequestBody TodoListReqDto todoListReqDto) {
        return todoListService.createTodoList(todoListReqDto);
    }

    @PutMapping("/{id}")
    public TodoListDto updateTodoList(@PathVariable Integer id, @RequestBody TodoListReqDto todoListReqDto) {
        return todoListService.updateTodoList(id, todoListReqDto);
    }

    @DeleteMapping("/{id}")
    public void deleteTodoList(@PathVariable Integer id) {
        todoListService.deleteTodoList(id);
    }

    @GetMapping("/{id}")
    public TodoListDto getTodoListById(@PathVariable Integer id) {
        return todoListService.getTodoListById(id);
    }
}
