package com.example.TaskManager.entities;

import lombok.Data;


import java.util.Date;


@Data
public class TaskEntity {
    private int id;
    private String title;
    private String description;
    private String priority;
    private Date deadline;
    private boolean completed;

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
    public boolean getCompleted() {
        return completed;
    }

    public Date getDeadline() {
        return deadline;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getPriority() {
        return priority;
    }

    public String getTitle() {
        return title;
    }
}
