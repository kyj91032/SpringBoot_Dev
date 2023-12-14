package com.example.springboot_dev.Board.Data;

import com.example.springboot_dev.Comment.Data.CommentResponseDTO;
import com.example.springboot_dev.User.Data.UserEntity;
import com.example.springboot_dev.User.Data.UserResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
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

}
