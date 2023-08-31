package org.example.service;

import org.example.data.model.User;
import org.example.data.repository.UserRepo;
import org.example.dto.LoginRequest;
import org.example.dto.LoginResponse;
import org.example.dto.RegisterRequest;
import org.example.utility.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepo userRepo;
    @Override
    public void signup(RegisterRequest request) {
        var user =User.builder()
                .lastName(request.getLastName())
                .password(request.getPassword())
                .username(request.getUsername())
                .email(request.getEmail())
                .firstName(request.getFirstName())
                .build();
        userRepo.save(user);
    }

    @Override
    public LoginResponse login(LoginRequest request) {
        Optional<User> user = userRepo.findByUsername(request.getUsername());
        var validateUser = user.isPresent();
        User savedUser = user.get();
        if (savedUser.getPassword().equals(request.getPassword())) {
            var response = LoginResponse.builder()
                    .username(savedUser.getUsername())
                    .email(savedUser.getEmail())
                    .firstName(savedUser.getFirstName())
                    .lastName(savedUser.getLastName())
                    .build();
            return response;
        }
        throw new UserNotFoundException("User not found");
    }
}
