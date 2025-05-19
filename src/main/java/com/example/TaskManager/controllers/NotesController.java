package com.example.TaskManager.controllers;

import com.example.TaskManager.dtos.createNotesDto;
import com.example.TaskManager.dtos.createNotesResponseDto;
import com.example.TaskManager.entities.NotesEntity;
import com.example.TaskManager.services.NotesService;
import com.example.TaskManager.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/tasks/{taskId}/notes")
public class NotesController {
    @Autowired
    private TaskService taskService;
    @Autowired
    private NotesService notesService;

    @PostMapping("")
    public ResponseEntity<createNotesResponseDto> addNotesForTask(@PathVariable int taskId, @RequestBody createNotesDto data){
        NotesEntity notesEntity = notesService.addNotesForTask(taskId,data.title,data.description);
        return ResponseEntity.ok(new createNotesResponseDto(taskId, notesEntity));
    }

    @GetMapping("")
    public ResponseEntity<List<NotesEntity>> getNotesForTask(@PathVariable int taskId){
        return ResponseEntity.ok(notesService.getNotesForTask(taskId));
    }
    @GetMapping("/{Id}")
    public ResponseEntity<NotesEntity> getNotesForTaskById(@PathVariable int taskId,@PathVariable int Id){
        return ResponseEntity.ok(notesService.getNotesForTaskById(taskId,Id));
    }
    @PatchMapping("/{Id}")
    public ResponseEntity<createNotesResponseDto> updateNotesForTaskByNotesId(@PathVariable int taskId,@PathVariable int Id,@RequestBody createNotesDto data){
        NotesEntity notesEntity = notesService.updateNotesForTaskByNotesId(taskId,Id,data.title,data.description);
        return ResponseEntity.ok(new createNotesResponseDto(taskId,notesEntity));
    }
    @DeleteMapping("")
    public ResponseEntity<ArrayList<NotesEntity>> deleteAllNotesForTask(@PathVariable int taskId){
        return ResponseEntity.ok(notesService.deleteAllNotesForTask(taskId));
    }
    @DeleteMapping("/{Id}")
    public ResponseEntity<ArrayList<NotesEntity>> deleteNotesForTaskByNotesId(@PathVariable int taskId,@PathVariable int Id){
        return ResponseEntity.ok(notesService.deleteNotesForTaskByNotesId(taskId,Id));
    }

}
