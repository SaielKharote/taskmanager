package com.scaler.taskmanager.services;

import org.springframework.stereotype.Service;

@Service
public class NotesService {
    final NotesService notesService;

    public NotesService(NotesService notesService) {
        this.notesService = notesService;
    }
}
