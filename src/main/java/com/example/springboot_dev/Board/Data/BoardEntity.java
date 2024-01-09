package com.example.springboot_dev.Board.Data;

import com.example.springboot_dev.Comment.Data.CommentEntity;
import com.example.springboot_dev.User.Data.UserEntity;
import com.example.springboot_dev.User.Data.UserResponseDTO;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Table(name = "board")
@Entity
@NoArgsConstructor
@Getter
public class BoardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bid")
    private Long bid;

    @Column(name = "title", length = 20, nullable = false)
    private String title;

    @Column(name="content", nullable = false)
    private String content;

    @Column(name = "category", nullable = false)
    private String category;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "uid")
    private UserEntity user;

    @OneToMany(mappedBy = "board", fetch = FetchType.LAZY)
    private List<CommentEntity> commentList;

    @Builder
    public BoardEntity(String title, String content, String category, LocalDateTime createdAt, LocalDateTime updatedAt, UserEntity user) {
        this.title = title;
        this.content = content;
        this.category = category;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.user = user;
    }

    public void update(String content) {
        this.content = content;
        this.updatedAt = LocalDateTime.now();
    }

    // BoardEntity를 BoardResponseDTO로 변환
    public static BoardResponseDTO from(BoardEntity entity) {
        return BoardResponseDTO.builder()
                .bid(entity.getBid())
                .title(entity.getTitle())
                .content(entity.getContent())
                .category(entity.getCategory())
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .user(UserResponseDTO.builder()
                        .uid(entity.getUser().getUid())
                        .userName(entity.getUser().getUserName())
                        .password(entity.getUser().getPassword())
                        .email(entity.getUser().getEmail())
                        .createdAt(entity.getUser().getCreatedAt())
                        .build())
                .build();
    }


}
