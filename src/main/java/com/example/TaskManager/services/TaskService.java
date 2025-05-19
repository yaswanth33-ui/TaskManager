package com.example.TaskManager.services;

import com.example.TaskManager.entities.TaskEntity;
import org.springframework.stereotype.Service;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Service
public class TaskService {

    private final ArrayList<TaskEntity> tasks = new ArrayList<>();
    private int taskId = 1;
    private final SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);

    private Date parseFlexibleDate(String dateStr) throws ParseException {
        List<SimpleDateFormat> formatters = List.of(
                new SimpleDateFormat("yyyy-MM-dd"),
                new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.ENGLISH)
        );

        for (SimpleDateFormat formatter : formatters) {
            try {
                return formatter.parse(dateStr);
            } catch (ParseException ignored) {
            }
        }

        throw new ParseException("Unparseable date: \"" + dateStr + "\"", 0);
    }


    public TaskEntity addTask(String title, String description, String priority, String deadline) throws ParseException {
        TaskEntity task = new TaskEntity();
        task.setId(taskId);
        task.setTitle(title);
        task.setDescription(description);
        task.setPriority(priority);
        task.setDeadline(this.parseFlexibleDate(deadline));
        tasks.add(task);
        taskId++;
        return task;
    }

    public ArrayList<TaskEntity> getTasks() {
        return tasks;
    }

    public TaskEntity getTaskById(int id){
        TaskEntity task = new TaskEntity();
        for(TaskEntity taskEntity:tasks ){
            if(taskEntity.getId() == id) {
                task = taskEntity;
            }
        }
        return task;
    }

    public TaskEntity updateTaskById(int id,String title,String description,String priority,String deadline,boolean completed) throws ParseException{
        for(TaskEntity task : tasks){
            if (task.getId()==id){
                task.setTitle(title);
                task.setDescription(description);
                task.setPriority(priority);
                task.setDeadline(this.parseFlexibleDate(deadline));
                task.setCompleted(completed);
                return task;
            }
        }
        return null;
    }

    public ArrayList<TaskEntity> deleteTaskById(int id){
        for(TaskEntity task : tasks){
            if (task.getId()==id){
                tasks.remove(task);
                break;
            }
        }
        return tasks;
    }
}
