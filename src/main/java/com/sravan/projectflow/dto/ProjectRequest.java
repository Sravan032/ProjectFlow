package com.sravan.ProjectFlow.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class ProjectRequest {
    @NotBlank(message = "Title is required")
    private String title;

    private String description;

    @NotNull(message = "Deadline is required")
    private LocalDate deadline;

    public ProjectRequest() {}

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

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }
}
