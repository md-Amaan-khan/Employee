package com.example.Employee.service;

import com.example.Employee.request.UserRequest;
import com.example.Employee.response.UserResponse;
import com.example.Employee.response.list.UserResponseList;

public interface UserService {
    void createUser(UserRequest request);

    UserResponse getById(Long userId);

    UserResponseList getAllId(Integer pageNumber, Integer pageSize, String sortBy, String sortDir);

    void updateById(Long userId, UserRequest request);

    void deleteById(Long userId);
}
