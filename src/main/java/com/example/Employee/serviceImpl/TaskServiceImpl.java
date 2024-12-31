package com.example.Employee.serviceImpl;

import com.example.Employee.repository.TaskRepository;
import com.example.Employee.request.TaskRequest;
import com.example.Employee.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImpl implements TaskService {
@Autowired
private TaskRepository taskRepository;


    @Override
    public void create(TaskRequest taskRequest) {

    }
}
