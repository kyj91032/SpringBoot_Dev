package com.example.springboot_dev.User.Data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserRequestDTO {

    private String userName;

    private String password;

    private String email;

    private LocalDateTime createdAt;

    public UserEntity toEntity(){ // DTO에서 필요한 부분을 빌더 패턴을 통해 엔티티로 만들어주는 메서드
        return UserEntity.builder()
                .userName(userName)
                .password(password)
                .email(email)
                .createdAt(createdAt)
                .build();
    }
}
