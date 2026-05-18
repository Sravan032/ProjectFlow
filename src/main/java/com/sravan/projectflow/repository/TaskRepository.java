package com.sravan.ProjectFlow.repository;

import com.sravan.ProjectFlow.entity.Task;
import com.sravan.ProjectFlow.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TaskRepository extends JpaRepository<Task,Long> {
    List<Task> findByAssignedUser(User user);
}
