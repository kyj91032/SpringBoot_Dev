package com.example.springboot_dev.Comment.Data;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class CommentRequestDTO {

    private Long uid;

    private Long bid;

    private String comment;

}
