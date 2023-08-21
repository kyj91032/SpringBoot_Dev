package com.example.springboot_dev.User.Data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
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
