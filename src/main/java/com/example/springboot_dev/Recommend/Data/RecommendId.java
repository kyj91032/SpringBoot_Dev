package com.example.springboot_dev.Recommend.Data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecommendId implements Serializable { // 복합키로 쓸 것들이 RecommendEntity와 필드 이름이 같아야 함

    private Long user;

    private Long board;

}
