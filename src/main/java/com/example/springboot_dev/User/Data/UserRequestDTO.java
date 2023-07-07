package com.example.springboot_dev.User.Data;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UserRequestDTO {

    private String uname;

    private String pw;

    public UserEntity toEntity(){
        return UserEntity.builder()
                .uname(uname)
                .pw(pw)
                .build();
    }
}
