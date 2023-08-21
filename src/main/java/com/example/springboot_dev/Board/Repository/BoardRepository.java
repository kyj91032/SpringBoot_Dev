package com.example.springboot_dev.Board.Repository;

import com.example.springboot_dev.Board.Data.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface BoardRepository extends JpaRepository<BoardEntity, Long> {

    // 게시물 단일 조회 fetch join
    @Query("SELECT DISTINCT b FROM BoardEntity b LEFT JOIN FETCH b.comments WHERE b.bid = :boardId")
    Optional<BoardEntity> findByIdWithComments(@Param("boardId") Long boardId);

}
