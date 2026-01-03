package com.ammarat.spring_todolist.mappers;

import com.ammarat.spring_todolist.dto.TodoListReqDto;
import com.ammarat.spring_todolist.entities.TodoList;
import org.springframework.stereotype.Component;

@Component
public class TodoListReqDtoMap {

    public TodoListReqDto toDto(TodoList todo) {
        TodoListReqDto dto = new TodoListReqDto();
        dto.setTitle(todo.getTitle());
        dto.setDescription(todo.getDescription());
        return dto;
    }

    public TodoList toEntity(TodoListReqDto dto) {
        TodoList todo = new TodoList();
        todo.setTitle(dto.getTitle());
        todo.setDescription(dto.getDescription());
        return todo;
    }
}
