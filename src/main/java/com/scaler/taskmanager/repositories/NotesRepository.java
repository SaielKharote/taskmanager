package com.scaler.taskmanager.repositories;

import com.scaler.taskmanager.entities.NoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotesRepository extends JpaRepository<NoteEntity, Integer> {
}
