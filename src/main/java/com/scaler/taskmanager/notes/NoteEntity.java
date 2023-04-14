package com.scaler.taskmanager.notes;

import com.scaler.taskmanager.tasks.TaskEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "notes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NoteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Integer id;

    @Column(nullable = false, length = 500)
    String body;

    @ManyToOne()
    TaskEntity task;

    public NoteEntity(String body, TaskEntity task) {
        this.body = body;
        this.task = task;
    }
}
