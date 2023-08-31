package org.example.dto;

import lombok.Data;
import org.example.data.model.Picture;

@Data
public class RegisterRequest {
    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private String password;
    private Picture displayPicture;
}
