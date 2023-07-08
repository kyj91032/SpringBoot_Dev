package com.example.springboot_dev.Comment.Data;

import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
public class CommentResponseDTO {

    private Long cid;

    private String ccontent;

    private Long uid;

    private String uname;

    private String pw;

    private Long bid;

    private String bname;

    private String bcontent;

}
