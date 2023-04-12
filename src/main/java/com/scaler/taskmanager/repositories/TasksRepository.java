package com.scaler.taskmanager.repositories;

import com.scaler.taskmanager.entities.TaskEntity;
import jakarta.persistence.criteria.From;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface TasksRepository extends JpaRepository<TaskEntity, Integer> {

    List<TaskEntity> findAllByCompleted(boolean completed);

    List<TaskEntity> findAllByCompletedAndDueDateBefore(Boolean completed, Date dueDate);

    List<TaskEntity> findAllByTitleContainingIgnoreCase(String titleFragment);

}
