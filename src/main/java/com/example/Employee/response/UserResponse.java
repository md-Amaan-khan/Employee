package com.example.Employee.response;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserResponse {
    private Long userId;
    private String userName;
    private String password;
    private String email;
}
