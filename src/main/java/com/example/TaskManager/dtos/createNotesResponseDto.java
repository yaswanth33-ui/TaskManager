package com.example.TaskManager.dtos;

import com.example.TaskManager.entities.NotesEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@Setter
@Getter
@AllArgsConstructor
public class createNotesResponseDto {
    private Integer id;
    private NotesEntity notes;

    public createNotesResponseDto(int id, NotesEntity notes) {
        this.id = id;
        this.notes = notes;
    }
}
