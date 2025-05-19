package com.example.TaskManager.controllers;


import com.example.TaskManager.dtos.TaskResponseDto;
import com.example.TaskManager.dtos.createTaskDto;
import com.example.TaskManager.dtos.updateTaskDto;
import com.example.TaskManager.entities.TaskEntity;
import com.example.TaskManager.services.NotesService;
import com.example.TaskManager.services.TaskService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.ArrayList;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    private TaskService taskService;
    @Autowired
    private NotesService notesService;
    private ModelMapper modelMapper = new ModelMapper();

    @PostMapping("")
    public ResponseEntity<TaskEntity> addTask(@RequestBody createTaskDto task) throws ParseException {
            TaskEntity taskdata;
            taskdata = taskService.addTask(task.title, task.description, task.priority, task.deadline);
            return ResponseEntity.ok(taskdata);
    }

    @GetMapping("")
    public ResponseEntity<ArrayList<TaskEntity>> getTasks() {
        return ResponseEntity.ok(taskService.getTasks());
    }

    @GetMapping("/{Id}")
    public ResponseEntity<TaskResponseDto> getTaskById(@PathVariable Integer Id ){
        var taskResponse = new TaskResponseDto();
        var task = taskService.getTaskById(Id);
        taskResponse.setTitle(task.getTitle());
        taskResponse.setDescription(task.getDescription());
        taskResponse.setPriority(task.getPriority());
        taskResponse.setDeadline(task.getDeadline().toString());
        taskResponse.setCompleted(task.getCompleted());
        taskResponse.setNotes(notesService.getNotesForTask(Id));
        return ResponseEntity.ok(taskResponse);
    }

    @PatchMapping("/{Id}")
    public ResponseEntity<TaskEntity> updateTaskById(@PathVariable Integer Id,@RequestBody updateTaskDto data) throws ParseException {
        return ResponseEntity.ok(taskService.updateTaskById(
                Id,
                data.title!=null?data.title:taskService.getTaskById(Id).getTitle(),
                data.description!=null?data.description:taskService.getTaskById(Id).getDescription(),
                data.priority!=null?data.priority:taskService.getTaskById(Id).getPriority(),
                data.deadline!=null?data.deadline:taskService.getTaskById(Id).getDeadline().toString(),
                data.completed)
        );
    }

    @DeleteMapping("/{Id}")
    public ResponseEntity<ArrayList<TaskEntity>> deleteTaskById(@PathVariable Integer Id){
        return ResponseEntity.ok(taskService.deleteTaskById(Id));
    }

}
