package com.scaler.taskmanager.repositories;

import com.scaler.taskmanager.entities.TaskEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
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

    @Test
    public void findAllByCompletedTest() {
        TaskEntity task1 = new TaskEntity();
        task1.setTitle("task 1");
        task1.setDescription("desc 1");
        task1.setCompleted(true);
        tasksRepository.save(task1);
        List<TaskEntity> completedTasks = tasksRepository.findAllByCompleted(true);
        TaskEntity task2 = new TaskEntity();
        task2.setTitle("task 2");
        task2.setDescription("desc 2");
        task2.setCompleted(false);
        tasksRepository.save(task2);
        List<TaskEntity> incompletedTasks = tasksRepository.findAllByCompleted(false);

        assertEquals(1, completedTasks.size());
        assertEquals(1, incompletedTasks.size());
    }

}
