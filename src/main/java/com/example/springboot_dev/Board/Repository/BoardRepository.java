package com.example.springboot_dev.Board.Repository;

import com.example.springboot_dev.Board.Data.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<BoardEntity, Long> {


}
