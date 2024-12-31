package com.example.Employee.serviceImpl;

import com.example.Employee.request.UserRequest;

import com.example.Employee.model.User;
import com.example.Employee.repository.UserRepository;
import com.example.Employee.request.UserRequest;
import com.example.Employee.response.UserResponse;
import com.example.Employee.response.list.UserResponseList;
import com.example.Employee.service.UserService;

import com.example.Employee.utility.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder encoder;

    @Override
    public void createUser(UserRequest request) {
        User user = new User();
        user.setUserName(request.getUserName());
        user.setPassword(encoder.encode(request.getPassword()));
//       user.setPassword(request.getPassword());
        user.setEmail(request.getEmail());
        user.setRole(Role.ROLE_USER);
        userRepository.save(user);


//        user.setUserName(request.getuserName());
//        user.setPassword(request.getPassword());
//        user.setEmail(request.getEmail());
//        userRepository.save(user);
    }

    @Override
    public UserResponse getById(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        UserResponse userResponse = new UserResponse();
        userResponse.setUserId(user.getUserId());
        userResponse.setUserName(user.getUserName());
        userResponse.setPassword(user.getPassword());
        userResponse.setEmail(user.getEmail());
        return userResponse;
    }

    @Override
    public UserResponseList getAllId(Integer pageNumber, Integer pageSize, String sortBy, String sortDir) {
        PageRequest asc = PageRequest.of(pageNumber, pageSize, sortDir.equalsIgnoreCase("asc") ? Sort.Direction.ASC : Sort.Direction.DESC, sortBy);
        Page<User> users = userRepository.findAll(asc);
        List<UserResponse> list = users.stream().map(this::changeToResponse).toList();
        return new UserResponseList(pageNumber, pageSize, sortDir, sortBy, users.getTotalPages(), list);

    }

    @Override
    public void updateById(Long userId, UserRequest request) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("user not found"));
        user.setEmail(request.getEmail());
        user.setUserName(request.getUserName());
        user.setPassword(request.getPassword());
        userRepository.save(user);
    }

    @Override
    public void deleteById(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        userRepository.delete(user);
    }

    public UserResponse changeToResponse(User user) {
        UserResponse userResponse = new UserResponse();
        userResponse.setUserId(user.getUserId());
        userResponse.setUserName(user.getUserName());
        userResponse.setPassword(user.getPassword());
        userResponse.setEmail(user.getEmail());
        return userResponse;
    }
}
