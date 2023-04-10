package com.scaler.taskmanager.entities;

import jakarta.persistence.*;
import org.springframework.data.auditing.CurrentDateTimeProvider;

import java.util.Date;

@Entity(name = "tasks")
public class TaskEntity extends BaseEntity{
    @Column(name = "title", nullable = false, length = 150)
    String title;

    @Column(name = "description", nullable = true, length = 500)
    String description;

    @Column(name = "due_date", nullable = true)
    Date dueDate;

    @Column(name = "completed", nullable = false, columnDefinition = "boolean default false")
    boolean completed;

}
