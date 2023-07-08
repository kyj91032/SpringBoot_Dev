package com.example.springboot_dev.Comment.Data;

import com.example.springboot_dev.Board.Data.BoardEntity;
import com.example.springboot_dev.User.Data.UserEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "comment")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class CommentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cid;

    @Column(name = "commentContent")
    private String ccontent;

    @ManyToOne
    @JoinColumn(name = "uId")
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "bId")
    private BoardEntity board;

    public CommentEntity(String ccontent, UserEntity user, BoardEntity board) {
        this.ccontent = ccontent;
        this.user = user;
        this.board = board;
    }

}
