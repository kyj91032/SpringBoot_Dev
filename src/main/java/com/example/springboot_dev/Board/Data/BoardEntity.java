package com.example.springboot_dev.Board.Data;

import com.example.springboot_dev.User.Data.UserEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.catalina.User;

@Table(name = "board")
@Entity
@AllArgsConstructor
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

    public BoardEntity(String bname, String bcontent, UserEntity user) {
        this.bname = bname;
        this.bcontent = bcontent;
        this.user = user;
    }



}
