package com.scaler.taskmanager.notes;

import com.scaler.taskmanager.notes.dtos.CreateNoteDTO;
import com.scaler.taskmanager.tasks.TaskEntity;
import com.scaler.taskmanager.tasks.TasksService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class NotesService {
    private NotesRepository notesRepository;

    private TasksService tasksService;

    private CreateNoteDTO createNoteDTO;

    @Autowired
    public NotesService(TasksService tasksService) {
        this.tasksService = tasksService;
    }


    public List<NoteEntity> getNotesForTask(Integer taskId) {
        return notesRepository.findAllByTaskId(taskId);
    }

    public NoteEntity addNewNote(Integer taskId, String body){
        TaskEntity parentTask = tasksService.getTaskById(taskId);
        NoteEntity note = new NoteEntity(createNoteDTO.getBody(), parentTask);
        return notesRepository.save(note);

    }

    public void deleteNote(Integer noteId){
        notesRepository.deleteById(noteId);
    }

}
