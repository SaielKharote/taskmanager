package com.scaler.taskmanager.tasks.dtos;

import jakarta.annotation.Nullable;
import lombok.Data;

import java.util.Date;

@Data
public class TaskResponseDTO {
    private Integer id;
    private String title;
    private String description;
    private Date dueDate;
    private Boolean completed;
}
