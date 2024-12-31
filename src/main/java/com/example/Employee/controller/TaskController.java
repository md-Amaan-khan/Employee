package com.example.Employee.controller;

import com.example.Employee.request.TaskRequest;
import com.example.Employee.response.util.MessageResponse;
import com.example.Employee.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class TaskController {
    @Autowired
    private TaskService taskService;
    @PostMapping("/")
    public ResponseEntity<MessageResponse> create (@RequestBody TaskRequest taskRequest){
        taskService.create(taskRequest);
    return new ResponseEntity<>(new MessageResponse("Task Created"), HttpStatus.OK);
    }

}
