package com.example.TaskManager.dtos;

import com.example.TaskManager.entities.NotesEntity;

import java.util.List;

public class TaskResponseDto {
    public String title;
    public String description;
    public String priority;
    public String deadline;
    public boolean completed;
    private List<NotesEntity> notes;


    public void setTitle(String title) {
        this.title = title;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setPriority(String priority) {
        this.priority = priority;
    }
    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }
    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
    public String getTitle() {
        return title;
    }
    public String getDescription() {
        return description;
    }
    public String getPriority() {
        return priority;
    }
    public String getDeadline() {
        return deadline;
    }
    public boolean getCompleted() {
        return completed;
    }

    public List<NotesEntity> getNotes() {
        return notes;
    }
    public void setNotes(List<NotesEntity> notes) {
        this.notes = notes;
    }
}
