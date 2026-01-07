package com.ammarat.spring_todolist.dto;


import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class TodoListReqDto {
    @NotBlank(message = "Le titre est obligatoire")
    private String title;
    @NotBlank(message = "La description est obligatoire")
    private String description;
}
