package com.atharva.ComplianceManager.entity;

import com.razorpay.Product;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
public class AuditLog {
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
    @NotNull
    @ManyToOne
    @JoinColumn(name = "complianceItem_id")
    private ComplianceItem complianceItem;
    @NotNull
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @NotNull
    private String action;
    private String details;
    @CreationTimestamp
    private LocalDateTime createdAt;

//    public AuditLog() {
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
//    public @NotNull ComplianceItem getComplianceItem() {
//        return complianceItem;
//    }
//
//    public void setComplianceItem(@NotNull ComplianceItem complianceItem) {
//        this.complianceItem = complianceItem;
//    }
//
//    public @NotNull User getUser() {
//        return user;
//    }
//
//    public void setUser(@NotNull User user) {
//        this.user = user;
//    }
//
//    public @NotNull String getAction() {
//        return action;
//    }
//
//    public void setAction(@NotNull String action) {
//        this.action = action;
//    }
//
//    public String getDetails() {
//        return details;
//    }
//
//    public void setDetails(String details) {
//        this.details = details;
//    }
//
//    public LocalDateTime getCreatedAt() {
//        return createdAt;
//    }
//
//    public void setCreatedAt(LocalDateTime createdAt) {
//        this.createdAt = createdAt;
//    }
}
