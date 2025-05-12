package com.atharva.ComplianceManager.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class AuditLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    @ManyToOne
    @JoinColumn(name = "task_id")
    private Task task;

    @ManyToOne
    @JoinColumn(name = "compliance_item_id")
    private ComplianceItem complianceItem;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String action;

    @Column(columnDefinition = "TEXT")
    private String details;

    private LocalDateTime createdAt;


}
