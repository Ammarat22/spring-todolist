package com.ammarat.spring_todolist.services;

import com.ammarat.spring_todolist.dto.TodoListDto;
import com.ammarat.spring_todolist.dto.TodoListReqDto;
import com.ammarat.spring_todolist.entities.TodoList;
import com.ammarat.spring_todolist.repositories.TodoListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TodoListService implements TodoListServiceImpl{

    private final TodoListRepository todoListRepository;

    public TodoListService (TodoListRepository todoListRepository) {
    this.todoListRepository = todoListRepository;
    }

    @Override
    public List<TodoListDto> getAllUsers(String order) {
        List<TodoList> todoLists = order != null && order.equalsIgnoreCase("desc")
                ? todoListRepository.findAllByOrderByIdDesc()
                : todoListRepository.findAll();
        List<TodoListDto> todoListDtos = new ArrayList<>();
        for (TodoList todoList : todoLists) {
            todoListDtos.add(todoListDtoMap.toDto(todoList));
        }
        return todoListDtos;
    }

    @Override
    public TodoListDto getTodoListById(Integer id) {
        return todoListRepository.findById(id)
                .map(TodoListDtoMap::toDto)
                .orElse(null);
    }

    @Override
    public TodoListDto createTodoList(TodoListReqDto todoListReqDto) {
        TodoList todo = mapToEntity(todoListDto);
        TodoList saved = todoListRepository.save(todo);
        return mapToDto(saved);
    }

    @Override
    public TodoListDto updateTodoList(Integer id, TodoListReqDto todoListReqDto) {

        TodoList existing = todoListRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(
                        "TodoList not found with id " + id
                ));
        // Mise à jour des champs
        existing.setTitle(todoListReqDto.getTitle());
        existing.setDescription(todoListReqDto.getDescription());

        TodoList updated = todoListRepository.save(existing);

        return mapToDto(updated);
    }


    @Override
    public void deleteTodoList(Integer id) {
        if (!todoListRepository.existsById(id)) {
            throw new RuntimeException("TodoList not found with id " + id);
        }
        todoListRepository.deleteById(id);
    }
}
