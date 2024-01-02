package com.example.springboot_dev.User.Data;

import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@Setter
@Getter
public class UserResponseDTO {

    private Long uid;

    private String userName;

    private String password;

    private String email;

    private LocalDateTime createdAt;

    @Builder
    public UserResponseDTO(Long uid, String userName, String password, String email, LocalDateTime createdAt) {
        this.uid = uid;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.createdAt = createdAt;
    }
}
