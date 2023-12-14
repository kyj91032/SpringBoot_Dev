package com.example.springboot_dev.User.Data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class UserResponseDTO {

    private Long uid;

    private String userName;

    private String password;

    private String email;

    private LocalDateTime createdAt;

}
