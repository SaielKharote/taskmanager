package com.scaler.taskmanager.notes;

import com.scaler.taskmanager.notes.dtos.CreateNoteDTO;
import com.scaler.taskmanager.notes.dtos.NoteResponseDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks/{taskId}/notes")
@AllArgsConstructor
public class NotesController {

    private final NotesService notesService;

    @GetMapping("")
    public ResponseEntity<List<NoteEntity>> getNotes(@PathVariable("taskId") Integer taskId) {
        List<NoteEntity> notes = notesService.getNotesForTask(taskId);

        return ResponseEntity.ok(notes);
    }

    @PostMapping("")
    public ResponseEntity<NoteResponseDTO> addNote(@PathVariable("taskId") Integer taskId, @RequestBody CreateNoteDTO addNote) {
        NoteEntity note = notesService.addNewNote(taskId, addNote.getBody());
        return ResponseEntity.ok(new NoteResponseDTO());
    }

}
