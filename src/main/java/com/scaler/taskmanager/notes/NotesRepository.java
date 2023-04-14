package com.scaler.taskmanager.notes;

import com.scaler.taskmanager.notes.NoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotesRepository extends JpaRepository<NoteEntity, Integer> {

    public List<NoteEntity> findAllByTaskId(Integer id);
}
