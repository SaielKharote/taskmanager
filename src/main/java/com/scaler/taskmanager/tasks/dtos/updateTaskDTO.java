package com.scaler.taskmanager.tasks.dtos;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class updateTaskDTO {
    Integer Id;
    String title;
    String description;
    Date dueDate;
    Boolean completed;
}
