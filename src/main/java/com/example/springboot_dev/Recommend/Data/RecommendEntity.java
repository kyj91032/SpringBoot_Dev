package com.example.springboot_dev.Recommend.Data;

import com.example.springboot_dev.Board.Data.BoardEntity;
import com.example.springboot_dev.User.Data.UserEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "recommend")
@Entity
@Data
@IdClass(RecommendId.class) // 복합키 클래스를 등록
@NoArgsConstructor
public class RecommendEntity {

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "uId")
    private UserEntity user;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bId")
    private BoardEntity board;



    public RecommendEntity(UserEntity user, BoardEntity board) {
        this.user = user;
        this.board = board;
    }

}
