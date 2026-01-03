package com.ammarat.spring_todolist.config;

import com.ammarat.spring_todolist.entities.TodoList;
import com.ammarat.spring_todolist.repositories.TodoListRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final TodoListRepository todoListRepository;

    public DataLoader(TodoListRepository todoListRepository) {
        this.todoListRepository = todoListRepository;
    }
    @Override
    public void run(String... args) {
        todoListRepository.save(new TodoList("test 1", "Salut"));
        todoListRepository.save(new TodoList("test 2", "Au revoir"));
    }
}