package com.scaler.taskmanager.repositories;

import com.scaler.taskmanager.entities.TaskEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
public class TasksRepositoryTests {
    @Autowired TasksRepository tasksRepository;

    @Test
    public void testCreateTask() {
        TaskEntity task = new TaskEntity();
        task.setTitle("Test Task");
        task.setDescription(" Test Description");
        task.setCompleted(false);
        TaskEntity savedTask = tasksRepository.save(task);
        assertNotNull(savedTask);
    }

}
