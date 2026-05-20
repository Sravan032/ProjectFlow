package com.sravan.ProjectFlow.service;

import com.sravan.ProjectFlow.dto.TaskRequest;
import com.sravan.ProjectFlow.entity.Project;
import com.sravan.ProjectFlow.entity.Task;
import com.sravan.ProjectFlow.entity.User;
import com.sravan.ProjectFlow.repository.ProjectRepository;
import com.sravan.ProjectFlow.repository.TaskRepository;
import com.sravan.ProjectFlow.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProjectRepository projectRepository;

    public Task createTask(TaskRequest request){
        Project project = projectRepository.findById(request.getProjectId())
                .orElseThrow(() -> new RuntimeException("Project not found!"));

        User user = userRepository.findById(request.getAssignedUserId())
                .orElseThrow(() -> new RuntimeException("Assigned User is not found!"));

        Task task = new Task();
        task.setTitle(request.getTitle());
        task.setDescription(request.getDescription());
        task.setStatus(request.getStatus());
        task.setPriority(request.getPriority());
        task.setProject(project);
        task.setAssignedUser(user);

        return taskRepository.save(task);
    }
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task getTaskById(Long id) {

        return taskRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Task not found")
                );
    }

    public String deleteTask(Long id) {

        taskRepository.deleteById(id);

        return "Task deleted successfully";
    }
    public Task updateTask(Long id, TaskRequest request) {

        Task task = taskRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Task not found")
                );

        Project project = projectRepository
                .findById(request.getProjectId())
                .orElseThrow(() ->
                        new RuntimeException("Project not found")
                );

        User user = userRepository
                .findById(request.getAssignedUserId())
                .orElseThrow(() ->
                        new RuntimeException("User not found")
                );

        task.setTitle(request.getTitle());
        task.setDescription(request.getDescription());
        task.setStatus(request.getStatus());
        task.setPriority(request.getPriority());

        task.setProject(project);
        task.setAssignedUser(user);

        return taskRepository.save(task);
    }
}
