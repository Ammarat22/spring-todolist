package com.ammarat.spring_todolist.config;

import com.ammarat.spring_todolist.entities.TodoList;
import com.ammarat.spring_todolist.repositories.TodoListRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {

    private final TodoListRepository todoListRepository;

    public DataLoader(TodoListRepository todoListRepository) {
        this.todoListRepository = todoListRepository;
    }

    @Override
    public void run(String... args) {
        if (todoListRepository.count() == 0) {
            List<TodoList> todoLists = List.of(
                    new TodoList("Faire les courses", "Acheter du savon"),
                    new TodoList("Réunion avec l'equipe", "Finir les taches à faire avant")
            );
            todoListRepository.saveAll(todoLists);
        }
    }
}