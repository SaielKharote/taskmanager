package com.scaler.taskmanager.tasks;

import com.scaler.taskmanager.tasks.dtos.CreateTaskDTO;
import com.scaler.taskmanager.tasks.dtos.TaskResponseDTO;
import com.scaler.taskmanager.tasks.dtos.UpdateTaskDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TasksService {
    private final TasksRepository tasksRepository;
    private final ModelMapper modelMapper;

    public TasksService(TasksRepository tasksRepository,ModelMapper modelMapper) {
        this.tasksRepository = tasksRepository;
        this.modelMapper = modelMapper;
    }

    List<TaskEntity> getAllTasks() {
        return tasksRepository.findAll();
    }

    public TaskResponseDTO createTask(CreateTaskDTO newTask) {
        // Data Validation
        if (newTask.getDueDate().before(new Date())) {
            throw new IllegalArgumentException("Due date cannot be in the past");
        }
        TaskEntity task = modelMapper.map(newTask, TaskEntity.class);
        task.setCompleted(false);
        task = tasksRepository.save(task);
        return modelMapper.map(task, TaskResponseDTO.class);
    }

    public TaskEntity getTaskById(Integer id) {
        return tasksRepository.findById(id).orElseThrow();
    }

    public TaskEntity updateTask(UpdateTaskDTO updateTaskDTO) {
        // Update the properties of the existing task entity with the new values from updateTaskDTO
        TaskEntity taskEntity = tasksRepository.findById(updateTaskDTO.getId()).orElse(null);
        if (taskEntity != null) {
            taskEntity.setTitle(updateTaskDTO.getTitle());
            taskEntity.setDescription(updateTaskDTO.getDescription());
            taskEntity.setDueDate(updateTaskDTO.getDueDate());
            taskEntity.setCompleted(updateTaskDTO.getCompleted());
            // set any other properties that need to be updated
            tasksRepository.save(taskEntity);
        }
        return taskEntity;
    }


    public void deleteTask(Integer id) {
        tasksRepository.deleteById(id);
    }
}
