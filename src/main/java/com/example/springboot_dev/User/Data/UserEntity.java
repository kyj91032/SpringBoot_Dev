package com.example.springboot_dev.User.Data;

import com.example.springboot_dev.Board.Data.BoardEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "user")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "uid")
    private Long uid;

    @Column(name = "userName", length = 20, nullable = false, unique = true) // unique 제약조건 추가
    private String userName;

    @Column(name = "password", length = 20, nullable = false)
    private String password;

    @Column(name = "email", length = 50, nullable = false)
    private String email;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<BoardEntity> boardList;

    @Builder
    public UserEntity(String userName, String password, String email, LocalDateTime createdAt) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.createdAt = createdAt;
    }

}
