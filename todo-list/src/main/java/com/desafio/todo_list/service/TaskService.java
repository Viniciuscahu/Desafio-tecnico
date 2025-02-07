package com.desafio.todo_list.service;

import com.desafio.todo_list.dto.TaskDTO;
import com.desafio.todo_list.model.Task;
import com.desafio.todo_list.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private final TaskRepository repository;

    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    public List<Task> getAllTasks() {
        return repository.findAll();
    }

    public Optional<Task> getTaskById(Long id) {
        return repository.findById(id);
    }

    public Task createTask(TaskDTO taskDTO) {
        Task task = new Task(taskDTO.title(), taskDTO.description(), taskDTO.status());
        return repository.save(task);
    }

    public Task updateTask(Long id, TaskDTO taskDTO) {
        return repository.findById(id)
                .map(task -> {
                    task.setTitle(taskDTO.title());
                    task.setDescription(taskDTO.description());
                    task.setStatus(taskDTO.status());
                    return repository.save(task);
                })
                .orElseThrow(() -> new RuntimeException("Task not found"));
    }

    public void deleteTask(Long id) {
        repository.deleteById(id);
    }
}
