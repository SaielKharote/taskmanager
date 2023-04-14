package com.scaler.taskmanager.tasks.dtos;

import lombok.*;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CreateTaskDTO {
    String title;
    String description;
    Date dueDate;
}
