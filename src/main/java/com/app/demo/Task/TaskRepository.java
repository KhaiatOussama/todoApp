package com.app.demo.Task;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface TaskRepository extends JpaRepository<Task, Long> {
    @Query("SELECT s FROM Task s WHERE s.title = ?1")
    Optional<Task> findTaskByTitle(String title);
}
