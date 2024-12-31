package com.example.Employee.model;
import com.example.Employee.utility.Role;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "users")
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String UserName;
    private String Password;
    private String email;
    @Enumerated(EnumType.STRING)
    private Role role;



}