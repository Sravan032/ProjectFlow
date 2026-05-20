package com.sravan.ProjectFlow.controller;

import com.sravan.ProjectFlow.dto.TaskRequest;
import com.sravan.ProjectFlow.entity.Task;
import com.sravan.ProjectFlow.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @PostMapping
    public Task createTask(
            @Valid @RequestBody TaskRequest request
    ) {

        return taskService.createTask(request);
    }

    @GetMapping
    public List<Task> getAllTasks() {

        return taskService.getAllTasks();
    }

    @GetMapping("/{id}")
    public Task getTaskById(
            @PathVariable Long id
    ) {

        return taskService.getTaskById(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public String deleteTask(
            @PathVariable Long id
    ) {

        return taskService.deleteTask(id);
    }

    @PutMapping("/{id}")
    public Task updateTask(
            @PathVariable Long id,
            @Valid @RequestBody TaskRequest request
    ) {

        return taskService.updateTask(id, request);
    }
}
