package com.example.springboot_dev.Comment.Data;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CommentRequestDTO {

    private String ccontent;

    private Long bid;

}
