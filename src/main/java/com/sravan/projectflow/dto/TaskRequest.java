package com.sravan.ProjectFlow.dto;

import com.sravan.ProjectFlow.entity.Project;
import com.sravan.ProjectFlow.enums.Priority;
import com.sravan.ProjectFlow.enums.TaskStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class TaskRequest {
    @NotBlank(message = "Title is required.")
    private String title;

    private String description;

    @NotNull(message = "Status is required.")
    private TaskStatus status;

    @NotNull(message = "Priority is required")
    private Priority priority;

    @NotNull(message = "Project ID is required")
    private Long projectId;

    @NotNull(message = "Assigned User ID is required")
    private Long assignedUserId;

    public TaskRequest() {}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Long getAssignedUserId() {
        return assignedUserId;
    }

    public void setAssignedUserId(Long assignedUserId) {
        this.assignedUserId = assignedUserId;
    }
}
