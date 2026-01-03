package com.ammarat.spring_todolist.services;

import com.ammarat.spring_todolist.dto.TodoListDto;
import com.ammarat.spring_todolist.dto.TodoListReqDto;
import com.ammarat.spring_todolist.entities.TodoList;
import com.ammarat.spring_todolist.mappers.TodoListDtoMap;
import com.ammarat.spring_todolist.mappers.TodoListReqDtoMap;
import com.ammarat.spring_todolist.repositories.TodoListRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TodoListService implements TodoListServiceImpl {

    private final TodoListRepository todoListRepository;
    private final TodoListDtoMap todoListDtoMap;
    private final TodoListReqDtoMap todoListReqDtoMap;

    public TodoListService(
            TodoListRepository todoListRepository,
            TodoListDtoMap todoListDtoMap,
            TodoListReqDtoMap todoListReqDtoMap
    ) {
        this.todoListRepository = todoListRepository;
        this.todoListDtoMap = todoListDtoMap;
        this.todoListReqDtoMap = todoListReqDtoMap;
    }

    @Override
    public List<TodoListDto> getAllTodoLists(String order) {
        List<TodoList> todoLists = order != null && order.equalsIgnoreCase("desc")
                ? todoListRepository.findAllByOrderByIdDesc()
                : todoListRepository.findAll();

        List<TodoListDto> todoListDtos = new ArrayList<>();
        for (TodoList todo : todoLists) {
            todoListDtos.add(todoListDtoMap.toDto(todo));
        }
        return todoListDtos;
    }

    @Override
    public TodoListDto getTodoListById(Integer id) {
        TodoList todo = todoListRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("TodoList not found with id " + id));
        return todoListDtoMap.toDto(todo);
    }

    @Override
    public TodoListDto createTodoList(TodoListReqDto todoListReqDto) {
        TodoList todo = todoListReqDtoMap.toEntity(todoListReqDto);
        TodoList saved = todoListRepository.save(todo);
        return todoListDtoMap.toDto(saved);
    }

    @Override
    public TodoListDto updateTodoList(Integer id, TodoListReqDto todoListReqDto) {
        TodoList existing = todoListRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("TodoList not found with id " + id));
        existing.setTitle(todoListReqDto.getTitle());
        existing.setDescription(todoListReqDto.getDescription());
        TodoList updated = todoListRepository.save(existing);
        return todoListDtoMap.toDto(updated);
    }

    @Override
    public void deleteTodoList(Integer id) {
        if (!todoListRepository.existsById(id)) {
            throw new RuntimeException("TodoList not found with id " + id);
        }
        todoListRepository.deleteById(id);
    }
}
