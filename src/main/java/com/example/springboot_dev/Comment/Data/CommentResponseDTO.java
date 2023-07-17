package com.example.springboot_dev.Comment.Data;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class CommentResponseDTO {

    private Long cid;

    private String ccontent;

}
