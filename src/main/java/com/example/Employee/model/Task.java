package com.example.Employee.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "Task")
@NoArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long TaskId;
    private Boolean Status;
    @ManyToOne
    @JoinColumn(name = "User_Id")
    private User user;
}
