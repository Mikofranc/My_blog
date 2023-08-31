package org.example.service;

import org.example.dto.LoginRequest;
import org.example.dto.LoginResponse;
import org.example.dto.RegisterRequest;

public interface UserService {
     void signup(RegisterRequest request);

     LoginResponse login(LoginRequest request);


}
