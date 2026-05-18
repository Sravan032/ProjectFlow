package com.sravan.ProjectFlow.repository;

import com.sravan.ProjectFlow.entity.Project;
import com.sravan.ProjectFlow.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProjectRepository extends JpaRepository<Project,Long> {
}
