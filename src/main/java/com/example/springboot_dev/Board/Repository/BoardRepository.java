package com.example.springboot_dev.Board.Repository;

import com.example.springboot_dev.Board.Data.BoardEntity;
import com.example.springboot_dev.Comment.Data.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface BoardRepository extends JpaRepository<BoardEntity, Long>, BoardCustomRepository {

    @Query("SELECT b FROM BoardEntity b LEFT JOIN FETCH b.commentList WHERE b.bid = :bid")
    // :bid는 @Param("bid")로 받아온다.
    BoardEntity findByBidWithCommentList(Long bid);

    List<BoardEntity> getPostListByCategory(String category);

}
