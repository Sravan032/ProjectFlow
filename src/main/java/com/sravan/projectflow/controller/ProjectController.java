package com.sravan.ProjectFlow.controller;

import com.sravan.ProjectFlow.dto.ProjectRequest;
import com.sravan.ProjectFlow.entity.Project;
import com.sravan.ProjectFlow.service.ProjectService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    // CREATE PROJECT
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public Project createProject(@Valid @RequestBody ProjectRequest request) {

        return projectService.createProject(request);
    }

    @GetMapping
    public List<Project> getAllProjects() {

        return projectService.getAllProjects();
    }

    @GetMapping("/{id}")
    public Project getProjectById(@PathVariable Long id) {

        return projectService.getProjectById(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public Project updateProject(@PathVariable Long id, @Valid @RequestBody ProjectRequest request) {

        return projectService.updateProject(id, request);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public String deleteProject(
            @PathVariable Long id
    ) {

        return projectService.deleteProject(id);
    }
}
