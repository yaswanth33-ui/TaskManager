package com.example.TaskManager.entities;

import lombok.Data;

@Data
public class NotesEntity {
    private int id;
    private String title;
    private String description;
    public void setId(int id) {
        this.id = id;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public int getId() {
        return id;
    }
    public String getDescription() {
        return description;
    }
    public String getTitle() {
        return title;
    }
}
