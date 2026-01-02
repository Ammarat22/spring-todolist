package com.ammarat.spring_todolist.dto;


import lombok.Data;
import java.time.LocalDateTime;

@Data
public class TodoListDto {
    private Integer id;
    private String title;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}

