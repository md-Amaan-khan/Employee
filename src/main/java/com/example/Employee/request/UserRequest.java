package com.example.Employee.request;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserRequest {


        private String userName;
        private String password;
        private String email;
}