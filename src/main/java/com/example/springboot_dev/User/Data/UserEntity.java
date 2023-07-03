package com.example.springboot_dev.User.Data;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user")
@NoArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId")
    private Long id;

    @Column(name = "name", length = 10, nullable = false)
    private String name;

    @Column(name = "password", length = 20, nullable = false)
    private String pw;

    @Builder
    public UserEntity(String name, String pw) {
        this.name = name;
        this.pw = pw;
    }
}
