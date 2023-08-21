package com.example.springboot_dev.Board.Data;

import com.example.springboot_dev.Comment.Data.CommentEntity;
import com.example.springboot_dev.Recommend.Data.RecommendEntity;
import com.example.springboot_dev.User.Data.UserEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.catalina.User;

import javax.xml.stream.events.Comment;
import java.util.ArrayList;
import java.util.List;

@Table(name = "board")
@Entity
@NoArgsConstructor
@Getter
public class BoardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bId")
    private Long bid;

    @Column(name = "title", length = 20, nullable = false)
    private String title;

    @Column(name="boardContent", length = 254, nullable = false)
    private String bcontent;

    // 자식 엔티티 = N = 연관관계의 주인 = 외래키 가짐 = 부모 엔티티를 조회, 수정, 삭제, 생성 모두 가능.
    // 부모 엔티티 = 1 = 자식 엔티티를 리스트로 가짐 = 자식 엔티티를 조회만 가능.

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "uId")
    private UserEntity user;

    @JsonIgnore // 순환 참조 방지?
    @OneToMany(mappedBy = "board", orphanRemoval = true) // mappedBy = "부모엔티티"
    private List<CommentEntity> comments = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "board", orphanRemoval = true)
    private List<RecommendEntity> recommends = new ArrayList<>();

    public BoardEntity(String title, String bcontent, UserEntity user) {
        this.title = title;
        this.bcontent = bcontent;
        this.user = user;
    }

}
