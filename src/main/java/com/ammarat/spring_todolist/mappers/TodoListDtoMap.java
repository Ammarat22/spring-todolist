package com.ammarat.spring_todolist.mappers;

import com.ammarat.spring_todolist.dto.TodoListDto;
import com.ammarat.spring_todolist.entities.TodoList;
import org.springframework.stereotype.Component;

@Component
public class TodoListDtoMap {

    public TodoListDto toDto(TodoList todo) {
        if (todo == null) return null;

        TodoListDto dto = new TodoListDto();
        dto.setId(todo.getId());
        dto.setTitle(todo.getTitle());
        dto.setDescription(todo.getDescription());
        return dto;
    }
}
