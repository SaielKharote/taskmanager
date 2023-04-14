package com.scaler.taskmanager.commons;

import lombok.Data;
import lombok.NonNull;

@Data
public class ErrorResponseDTO {
    @NonNull
    private String message;
}
