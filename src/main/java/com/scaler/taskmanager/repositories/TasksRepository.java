package com.scaler.taskmanager.repositories;

import com.scaler.taskmanager.entities.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TasksRepository extends JpaRepository<TaskEntity, Integer> {
}
