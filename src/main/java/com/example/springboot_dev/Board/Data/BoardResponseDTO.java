package com.example.springboot_dev.Board.Data;

import com.example.springboot_dev.User.Data.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class BoardResponseDTO { // 출력 전달 객체 (entity 로부터 만들어짐)

    // entity 로부터 모든 필드 받아올 수 있도록 모든 필드 작성.
    private Long bid;

    private String bname;

    private String content;

    private Long uid;

    private String uname;

    private String pw;

}
