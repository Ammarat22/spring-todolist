package com.ammarat.spring_todolist.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TodoList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String description;

    @Column(nullable = false, updatable = false)
    private Instant createdAt;
    @Column(nullable = false)
    private Instant updatedAt;

    // Add a business constructor with two parameters (title and description)
    public TodoList(String title, String description) {
        this.title = title;
        this.description = description;
    }
    // Avant insertion
    @PrePersist
    public void onCreate() {
        Instant now = Instant.now();
        this.createdAt = now;
        this.updatedAt =now;
    }

    // Avant mise à jour
    @PreUpdate
    public void onUpdate() {
        this.updatedAt =Instant.now();
    }
}


