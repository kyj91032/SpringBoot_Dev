package com.example.springboot_dev.Board.Data;

import com.example.springboot_dev.User.Data.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BoardRequestDTO { // 입력 전달 객체 (entity 를 만듦)

    private String title;

    private String content;

    private String category;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private Long uid; // uid로 받고 userEntity로 변환

    // user의 초기화도 해야한다면 toEntity 보다는 service 계층에서 dto를 entity로 변환하는 작업을 해주는 것이 좋다.
}
