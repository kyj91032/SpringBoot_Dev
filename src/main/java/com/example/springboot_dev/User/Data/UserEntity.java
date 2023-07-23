package com.example.springboot_dev.User.Data;

import com.example.springboot_dev.Board.Data.BoardEntity;
import com.example.springboot_dev.Comment.Data.CommentEntity;
import com.example.springboot_dev.Recommend.Data.RecommendEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
@NoArgsConstructor
@Getter
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_Id")
    private Long uid;

    @Column(name = "userName", nullable = false, unique = true) // unique 제약조건 추가
    private String uname;

    @Column(name = "password", length = 20, nullable = false)
    private String pw;

    @OneToMany(mappedBy = "user", orphanRemoval = true)
    private List<BoardEntity> boards = new ArrayList<>();

    @OneToMany(mappedBy = "user", orphanRemoval = true)
    private List<RecommendEntity> recommends = new ArrayList<>();

    @Builder
    public UserEntity(String uname, String pw) {
        this.uname = uname;
        this.pw = pw;
    }

}
