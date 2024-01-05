package com.example.springboot_dev.Board.Data;

import com.example.springboot_dev.Comment.Data.CommentResponseDTO;
import com.example.springboot_dev.User.Data.UserResponseDTO;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
public class PostWithCommentDTO {

    private Long bid;

    private String title;

    private String content;

    private String category;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private UserResponseDTO user;

    private List<CommentResponseDTO> commentList;

    @Builder
    public PostWithCommentDTO(Long bid, String title, String content, String category, LocalDateTime createdAt, LocalDateTime updatedAt, UserResponseDTO user, List<CommentResponseDTO> commentList) {
        this.bid = bid;
        this.title = title;
        this.content = content;
        this.category = category;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.user = user;
        this.commentList = commentList;
    }

}
