package com.example.springboot_dev.Comment.Data;

import com.example.springboot_dev.Board.Data.BoardEntity;
import com.example.springboot_dev.User.Data.UserEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
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
    @Column(name = "cid")
    private Long cid;

    @Column(name = "comment", nullable = false)
    private String comment;

    @Column(name = "created_at", nullable = false)
    private String createdAt;

    @Column(name = "modified_at", nullable = false)
    private String modifiedAt;

    @ManyToOne
    @JoinColumn(name = "uid") // user의 uid를 참조
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "bid")  // board의 bid를 참조
    private BoardEntity board;



}
