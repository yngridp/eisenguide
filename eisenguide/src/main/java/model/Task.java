package model;

import java.time.LocalDateTime;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O título da tarefa é obrigatório")
    private String title;

    @NotBlank(message = "A descrição da tarefa é obrigatória")
    private String description;

    @Enumerated(EnumType.STRING)
    private TaskCategory category;

    private LocalDateTime dueDate;

    private boolean isCompleted = false;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    
    private String objective; // Meta ou objetivo da tarefa
    private LocalDateTime goalDeadline; // Prazo para a meta

   
    public Task(Long id, String title, String description, TaskCategory category, LocalDateTime dueDate,
                boolean isCompleted, LocalDateTime createdAt, LocalDateTime updatedAt,
                String objective, LocalDateTime goalDeadline) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.category = category;
        this.dueDate = dueDate;
        this.isCompleted = isCompleted;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.objective = objective;
        this.goalDeadline = goalDeadline;
    }

    //  executado antes de salvar a entidade pela primeira vez
    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    // executado antes de atualizar a entidade
    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

   
    public String getObjective() {
        return objective;
    }

    public void setObjective(String objective) {
        this.objective = objective;
    }

    public LocalDateTime getGoalDeadline() {
        return goalDeadline;
    }

    public void setGoalDeadline(LocalDateTime goalDeadline) {
        this.goalDeadline = goalDeadline;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public TaskCategory getCategory() {
        return category;
    }

    public void setCategory(TaskCategory category) {
        this.category = category;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean isCompleted) {
        this.isCompleted = isCompleted;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
