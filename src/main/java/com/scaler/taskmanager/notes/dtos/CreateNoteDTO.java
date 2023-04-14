package com.scaler.taskmanager.notes.dtos;

import lombok.*;
import org.springframework.stereotype.Component;

@Getter
@Setter
@AllArgsConstructor
@Data
public class CreateNoteDTO {
    String title;
    String body;
}
