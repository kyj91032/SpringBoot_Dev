package com.example.springboot_dev.User.Data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class UserPostCountDTO {

    private String userName;

    private int postCount;

    @Builder
    public UserPostCountDTO(String userName, int postCount) {
        this.userName = userName;
        this.postCount = postCount;
    }
}
