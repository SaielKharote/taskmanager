package com.scaler.taskmanager.repositories;

import com.scaler.taskmanager.entities.NoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotesRepository extends JpaRepository<NoteEntity, Integer> {
}
