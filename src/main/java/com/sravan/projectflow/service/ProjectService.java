package com.sravan.ProjectFlow.service;

import com.sravan.ProjectFlow.dto.ProjectRequest;
import com.sravan.ProjectFlow.entity.Project;
import com.sravan.ProjectFlow.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    public Project createProject(ProjectRequest request) {

        Project project = new Project();

        project.setTitle(request.getTitle());
        project.setDescription(request.getDescription());
        project.setDeadline(request.getDeadline());

        return projectRepository.save(project);
    }

    public List<Project> getAllProjects() {

        return projectRepository.findAll();
    }

    public Project getProjectById(Long id) {

        return projectRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Project not found")
                );
    }

    // UPDATE PROJECT
    public Project updateProject(Long id, ProjectRequest request) {

        Project project = projectRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Project not found")
                );

        project.setTitle(request.getTitle());
        project.setDescription(request.getDescription());
        project.setDeadline(request.getDeadline());

        return projectRepository.save(project);
    }

    public String deleteProject(Long id) {

        projectRepository.deleteById(id);

        return "Project deleted successfully";
    }
}
