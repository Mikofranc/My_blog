package org.example.service;

import org.example.data.repository.UserRepo;
import org.example.dto.LoginRequest;
import org.example.dto.RegisterRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.hamcrest.MatcherAssert.assertThat;
import  static org.hamcrest.CoreMatchers.is;


import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UserServiceImplTest {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepo userRepo;
    @Test
    public void testToRegister(){
        RegisterRequest request = new RegisterRequest();
        request.setFirstName("micheal");
        request.setEmail("micheal@gmail.com");
        request.setUsername("miko");
        request.setPassword("1234");
        request.setLastName("Ayomide");
        userService.signup(request);
        assertEquals(1, userRepo.count());
    }
    @Test
    public void testThatRegisteredUserCanLogin(){
        LoginRequest request = new LoginRequest();
        request.setPassword("1234");
        request.setUsername("miko");
        var user=userService.login(request);
        System.out.println(user.toString());
        assertThat(user.getFirstName(),is("micheal"));
    }
    @Test
    public void testToThrowException(){
        LoginRequest request = new LoginRequest();
        request.setPassword("1234");
        request.setUsername("miko1");
        userService.login(request);
    }

}