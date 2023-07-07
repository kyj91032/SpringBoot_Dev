package com.example.springboot_dev.Board.Data;

import com.example.springboot_dev.User.Data.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@AllArgsConstructor
@Data
public class BoardRequestDTO { // 입력 전달 객체 (entity를 만듦)

//    private Long bid; auto increment라 필요 없음

    private String bname;

    private String content;

    private Long uid;

//    private UserEntity user; uid로 userentity를 가져오면 돼서 uid로 대체



}
