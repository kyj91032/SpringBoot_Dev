package com.example.springboot_dev.Data.Entity;

import jakarta.persistence.*;
import lombok.*;


@Getter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "user")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId")
    private Long id;

    @Column(name = "userName", length = 10, nullable = false)
    private String userName;

    @Column(name = "password", length = 20, nullable = false)
    private String pw;
}
