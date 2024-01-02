package com.example.springboot_dev.User.Data;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
public class UserSignUpDTO {

    private String userName;

    private String password;

    private String email;

}
