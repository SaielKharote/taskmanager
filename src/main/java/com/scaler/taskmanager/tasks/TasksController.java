package com.scaler.taskmanager.tasks;

import com.scaler.taskmanager.commons.ErrorResponseDTO;
import com.scaler.taskmanager.tasks.dtos.CreateTaskDTO;
import com.scaler.taskmanager.tasks.dtos.TaskResponseDTO;
import com.scaler.taskmanager.tasks.dtos.UpdateTaskDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TasksController {
    private final TasksService tasksService;

    public TasksController(TasksService tasksService) {
        this.tasksService = tasksService;
    }

    @GetMapping("")
    public ResponseEntity<List<TaskEntity>> getTasks() {
        List<TaskEntity> tasks = tasksService.getAllTasks();

        return ResponseEntity.ok(tasks);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskEntity> getTaskById(@PathVariable("id")Integer id) {
        TaskEntity task = tasksService.getTaskById(id);
        if (task == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(task);
    }

    @PostMapping("")
    public ResponseEntity<TaskResponseDTO> addTask(@RequestBody CreateTaskDTO addTask) throws ParseException {
        TaskResponseDTO savedTask = tasksService.createTask(addTask);
        return ResponseEntity.ok(savedTask);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<TaskEntity> updateTask(@PathVariable("id") Integer id, @RequestBody UpdateTaskDTO updateTask) throws ParseException {
        updateTask.setId(id);
        TaskEntity updatedTask = tasksService.updateTask(updateTask);

        if (updatedTask == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(updatedTask);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDTO> handleErrors(Exception e) {
        if (e instanceof ParseException) {
            return ResponseEntity.badRequest().body(new ErrorResponseDTO("Invalid date format"));
        }
        e.printStackTrace();
        return ResponseEntity.internalServerError().body(new ErrorResponseDTO("Internal Server Error"));
    }

}
