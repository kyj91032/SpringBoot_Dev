package com.example.springboot_dev.Board.Data;

import com.example.springboot_dev.Comment.Data.CommentResponseDTO;
import com.example.springboot_dev.User.Data.UserEntity;
import com.example.springboot_dev.User.Data.UserResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class BoardResponseDTO { // 출력 전달 객체 (entity 로부터 만들어짐)

    // entity 로부터 리턴할 모든 필드 작성
    private Long bid;

    private String bname;

    private String bcontent;

    private UserResponseDTO userResponseDTO;

    private List<CommentResponseDTO> comments;

    private int recommend;

}
