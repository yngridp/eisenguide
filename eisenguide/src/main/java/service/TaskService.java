package service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Task;
import model.TaskCategory;
import repository.TaskRepository;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    // Retorna todas as tarefas
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    // Busca uma tarefa pelo ID
    public Optional<Task> getTaskById(Long id) {
        return taskRepository.findById(id);
    }

    // Cria uma nova tarefa
    public Task createTask(Task task) {
        task.setCreatedAt(LocalDateTime.now());
        task.setUpdatedAt(LocalDateTime.now());
        return taskRepository.save(task);
    }

    // Atualiza uma tarefa existente
    public Task updateTask(Long id, Task taskDetails) {
        Task task = taskRepository.findById(id).orElseThrow(() -> new RuntimeException("Task not found"));
        task.setTitle(taskDetails.getTitle());
        task.setDescription(taskDetails.getDescription());
        task.setCategory(taskDetails.getCategory());
        task.setDueDate(taskDetails.getDueDate());

        // Atualiza os novos campos de objetivo e prazo da meta
        task.setObjective(taskDetails.getObjective());
        task.setGoalDeadline(taskDetails.getGoalDeadline());

        task.setUpdatedAt(LocalDateTime.now());
        return taskRepository.save(task);
    }

    // Deleta uma tarefa
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    // Retorna uma lista de tarefas por categoria
    public List<Task> getTasksByCategory(TaskCategory category) {
        return taskRepository.findByCategory(category);
    }
}
