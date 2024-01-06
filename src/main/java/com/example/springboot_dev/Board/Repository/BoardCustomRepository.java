package com.example.springboot_dev.Board.Repository;


import com.example.springboot_dev.Board.Data.BoardEntity;

import java.util.List;

public interface BoardCustomRepository {

    public List<BoardEntity> getPostListByCategory(String category);

}
