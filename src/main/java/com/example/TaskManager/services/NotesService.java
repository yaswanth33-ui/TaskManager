package com.example.TaskManager.services;

import com.example.TaskManager.entities.NotesEntity;
import com.example.TaskManager.entities.TaskEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class NotesService {

    private HashMap<Integer,TaskNotesHolder> taskNotes;
    private TaskService taskService;

    public NotesService(TaskService taskService){
        this.taskService = taskService;
        this.taskNotes = new HashMap<>();
    }

    class TaskNotesHolder{
        protected int notesId = 1;
        protected ArrayList<NotesEntity> notes = new ArrayList<>();
    }

    public NotesEntity addNotesForTask(int taskId,String title,String description){
        TaskEntity task = taskService.getTaskById(taskId);
        if(task == null){
            return null;
        }
        if(taskNotes.get(taskId) == null){
            taskNotes.put(taskId,new TaskNotesHolder());
        }
        NotesEntity notesEntity = new NotesEntity();
        notesEntity.setId(taskNotes.get(taskId).notesId);
        notesEntity.setTitle(title);
        notesEntity.setDescription(description);
        taskNotes.get(taskId).notes.add(notesEntity);
        taskNotes.get(taskId).notesId++;
        return notesEntity;
    }
    public List<NotesEntity> getNotesForTask(int taskId){
        System.out.println("Getting notes for task id: "+taskId);
        TaskEntity task = taskService.getTaskById(taskId);
        if(task == null){
            System.out.println("Task not found");
            return null;
        }
        if(taskNotes.get(taskId) == null){
            System.out.println("Task notes not found");
            taskNotes.put(taskId,new TaskNotesHolder());
        }
        var notes = taskNotes.get(taskId).notes;
        System.out.println("Found "+notes.size()+" notes");
        return notes;
    }

    public NotesEntity getNotesForTaskById(int taskId,int notesId){
        TaskEntity task = taskService.getTaskById(taskId);
        if(task == null){
            return null;
        }
        if(taskNotes.get(taskId) == null){
            taskNotes.put(taskId,new TaskNotesHolder());
        }
        for(NotesEntity notesEntity:taskNotes.get(taskId).notes){
            if(notesEntity.getId()==notesId){
                return notesEntity;
            }
        }
        return null;
    }
    public NotesEntity updateNotesForTaskByNotesId(int taskId,int notesId,String title,String description){
        TaskEntity task = taskService.getTaskById(taskId);
        if(task == null){
            return null;
        }
        if(taskNotes.get(taskId) == null){
            taskNotes.put(taskId,new TaskNotesHolder());
        }
        for(NotesEntity notesEntity:taskNotes.get(taskId).notes){
            if(notesEntity.getId()==notesId){
                notesEntity.setTitle(title);
                notesEntity.setDescription(description);
                return notesEntity;
            }
        }
        return null;
    }

    public ArrayList<NotesEntity> deleteNotesForTaskByNotesId(int taskId,int notesId){
        TaskEntity task = taskService.getTaskById(taskId);
        if(task == null){
            return null;
        }
        if(taskNotes.get(taskId) == null){
            taskNotes.put(taskId,new TaskNotesHolder());
        }
        for(NotesEntity notesEntity:taskNotes.get(taskId).notes){
            if(notesEntity.getId()==notesId){
                taskNotes.get(taskId).notes.remove(notesEntity);
                break;
            }
        }
        return taskNotes.get(taskId).notes;
    }

    public ArrayList<NotesEntity> deleteAllNotesForTask(int taskId){
        TaskEntity task = taskService.getTaskById(taskId);
        if(task == null){
            return null;
        }
        if(taskNotes.get(taskId) == null){
            taskNotes.put(taskId,new TaskNotesHolder());
        }
        ArrayList<NotesEntity> notes = taskNotes.get(taskId).notes;
        taskNotes.get(taskId).notes.clear();
        return taskNotes.get(taskId).notes;
    }

}
