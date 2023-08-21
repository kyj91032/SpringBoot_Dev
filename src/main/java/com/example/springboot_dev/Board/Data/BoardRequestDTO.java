package com.example.springboot_dev.Board.Data;

import com.example.springboot_dev.User.Data.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BoardRequestDTO { // 입력 전달 객체 (entity 를 만듦)

//    private Long bid; auto increment라 필요 없음

    private String title;

    private String bcontent;

    private Long uid;

//    private UserEntity user; uid로 userentity를 가져오면 돼서 uid로 대체



}
