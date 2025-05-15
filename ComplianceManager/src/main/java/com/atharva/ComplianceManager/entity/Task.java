package com.atharva.ComplianceManager.entity;

import com.atharva.ComplianceManager.enums.TaskPriority;
import com.atharva.ComplianceManager.enums.TaskStatus;
import jakarta.persistence.*;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Task {
//
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    @NotNull
    private String title;

    private String description;

    @ManyToOne
    @JoinColumn(name = "assigned_user_id")
    private User assignedUser;

    @Enumerated(EnumType.STRING)
    private TaskPriority priority;

    @Enumerated(EnumType.STRING)
    private TaskStatus status;
    @OneToMany
    private List<ComplianceItem> complianceItems;

    private LocalDateTime dueDate;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
//
//    public Task() {
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public Project getProject() {
//        return project;
//    }
//
//    public void setProject(Project project) {
//        this.project = project;
//    }
//
//    @NotNull
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(@NotNull String title) {
//        this.title = title;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public TaskPriority getPriority() {
//        return priority;
//    }
//
//    public void setPriority(TaskPriority priority) {
//        this.priority = priority;
//    }
//
//    public TaskStatus getStatus() {
//        return status;
//    }
//
//    public void setStatus(TaskStatus status) {
//        this.status = status;
//    }
//
//    public User getAssignedUser() {
//        return assignedUser;
//    }
//
//    public void setAssignedUser(User assignedUser) {
//        this.assignedUser = assignedUser;
//    }
//
//    public LocalDateTime getDueDate() {
//        return dueDate;
//    }
//
//    public void setDueDate(LocalDateTime dueDate) {
//        this.dueDate = dueDate;
//    }
//
//    public LocalDateTime getCreatedAt() {
//        return createdAt;
//    }
//
//    public void setCreatedAt(LocalDateTime createdAt) {
//        this.createdAt = createdAt;
//    }
//
//    public LocalDateTime getUpdatedAt() {
//        return updatedAt;
//    }
//
//    public void setUpdatedAt(LocalDateTime updatedAt) {
//        this.updatedAt = updatedAt;
//    }
}
