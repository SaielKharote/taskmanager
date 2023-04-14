package com.scaler.taskmanager.tasks;

import com.scaler.taskmanager.notes.NoteEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.auditing.CurrentDateTimeProvider;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;

@Entity(name = "tasks")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TaskEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(nullable = false, length = 150)
    private String title;

    @Column(nullable = true, length = 500)
    private String description;

    @Column(nullable = false)
    private Date dueDate;

    @Column(nullable = false)
    private Boolean completed = false;

    @OneToMany(targetEntity = NoteEntity.class, cascade = CascadeType.ALL, mappedBy = "task")
    private List<NoteEntity> notes;

}
