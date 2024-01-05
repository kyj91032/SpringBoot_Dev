package com.example.springboot_dev.Comment.Data;

import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@Setter
@Getter
public class CommentResponseDTO {

    private Long cid;

    private String comment;

    private LocalDateTime createdAt;

    private LocalDateTime modifiedAt;

    @Builder
    public CommentResponseDTO(Long cid, String comment, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.cid = cid;
        this.comment = comment;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }

}
