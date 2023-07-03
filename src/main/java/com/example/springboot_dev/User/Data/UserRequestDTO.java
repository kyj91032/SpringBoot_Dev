package com.example.springboot_dev.User.Data;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UserRequestDTO {
    private String name;
    private String pw;

    public UserEntity toEntity(){
        return UserEntity.builder()
                .name(name)
                .pw(pw)
                .build();
    }
}
