package com.example.Employee.serviceImpl;

import com.example.Employee.model.UserSecurity;
import com.example.Employee.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private transient UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        UserSecurity userSecurity = userRepository.findByEmail(email)
                .map(UserSecurity::new)
                .orElseThrow(() -> new RuntimeException("User Not Found"));
        System.out.println("userSecurity = " + userSecurity.getUsername() +"  P-> "+userSecurity.getPassword()
                                +"  User Role => "+userSecurity.getAuthorities());
        return userSecurity;
    }
}
