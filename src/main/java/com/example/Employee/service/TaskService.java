package com.example.Employee.service;

import com.example.Employee.model.Task;
import com.example.Employee.request.TaskRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskService {
    void create(TaskRequest taskRequest);
}
