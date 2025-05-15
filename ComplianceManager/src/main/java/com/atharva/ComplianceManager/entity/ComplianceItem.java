package com.atharva.ComplianceManager.entity;

import com.atharva.ComplianceManager.enums.CompliantStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.CurrentTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.repository.Lock;

import java.time.LocalDateTime;

@Entity
public class ComplianceItem {
//
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "task_id")
    private Task task;

    private String description;

    @Enumerated(EnumType.STRING)
    private CompliantStatus status;

    private LocalDateTime due_date;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "checkedBy_id")
    private User checkedBy;

    @CurrentTimestamp
    private LocalDateTime checkedAt;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

//    public ComplianceItem() {
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
//    public @NotNull Project getProject() {
//        return project;
//    }
//
//    public void setProject(@NotNull Project project) {
//        this.project = project;
//    }
//
//    public @NotNull Task getTask() {
//        return task;
//    }
//
//    public void setTask(@NotNull Task task) {
//        this.task = task;
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
//    public CompliantStatus getStatus() {
//        return status;
//    }
//
//    public void setStatus(CompliantStatus status) {
//        this.status = status;
//    }
//
//    public LocalDateTime getDue_date() {
//        return due_date;
//    }
//
//    public void setDue_date(LocalDateTime due_date) {
//        this.due_date = due_date;
//    }
//
//    public @NotNull User getCheckedBy() {
//        return checkedBy;
//    }
//
//    public void setCheckedBy(@NotNull User checkedBy) {
//        this.checkedBy = checkedBy;
//    }
//
//    public LocalDateTime getCheckedAt() {
//        return checkedAt;
//    }
//
//    public void setCheckedAt(LocalDateTime checkedAt) {
//        this.checkedAt = checkedAt;
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