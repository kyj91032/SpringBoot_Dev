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

    @Column(name = "boardName", length = 20, nullable = false)
    private String bname;

    @Column(name="boardContent", length = 254, nullable = false)
    private String bcontent;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "uId")
    private UserEntity user;

    @OneToMany(mappedBy = "board", orphanRemoval = true)
    private List<CommentEntity> comments = new ArrayList<>();

    @OneToMany(mappedBy = "board", orphanRemoval = true)
    private List<RecommendEntity> recommends = new ArrayList<>();

    public BoardEntity(String bname, String bcontent, UserEntity user) {
        this.bname = bname;
        this.bcontent = bcontent;
        this.user = user;
    }

}
