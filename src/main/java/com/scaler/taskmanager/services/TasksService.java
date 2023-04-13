package com.scaler.taskmanager.services;

import com.scaler.taskmanager.repositories.NotesRepository;
import com.scaler.taskmanager.repositories.TasksRepository;
import org.springframework.stereotype.Service;

@Service
public class TasksService {
    final TasksRepository tasksRepository;
    final NotesRepository notesRepository;

    public TasksService(TasksRepository tasksRepository, NotesRepository notesRepository) {
        this.tasksRepository = tasksRepository;
        this.notesRepository = notesRepository;
    }
}
