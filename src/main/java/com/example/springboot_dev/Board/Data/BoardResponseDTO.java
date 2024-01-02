package com.example.springboot_dev.Board.Data;

import com.example.springboot_dev.Comment.Data.CommentResponseDTO;
import com.example.springboot_dev.User.Data.UserEntity;
import com.example.springboot_dev.User.Data.UserResponseDTO;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@Setter
@Getter
public class BoardResponseDTO { // 출력 전달 객체 (entity 로부터 만들어짐)

    private Long bid;

    private String title;

    private String content;

    private String category;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private UserResponseDTO user; // userEntity로 받고 userResponseDTO로 변환

    @Builder
    public BoardResponseDTO(Long bid, String title, String content, String category, LocalDateTime createdAt, LocalDateTime updatedAt, UserResponseDTO user) {
        this.bid = bid;
        this.title = title;
        this.content = content;
        this.category = category;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.user = user;
    }

}
