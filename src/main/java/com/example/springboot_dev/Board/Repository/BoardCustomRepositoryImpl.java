package com.example.springboot_dev.Board.Repository;

import com.example.springboot_dev.Board.Data.BoardEntity;
import com.example.springboot_dev.Board.Data.BoardResponseDTO;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static com.example.springboot_dev.Board.Data.QBoardEntity.*;

@RequiredArgsConstructor
public class BoardCustomRepositoryImpl implements BoardCustomRepository{

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<BoardEntity> getPostListByCategory(String category) {
        return jpaQueryFactory
                .select(boardEntity)
                .from(boardEntity)
                .leftJoin(boardEntity.user).fetchJoin()
                // 추가 쿼리 발생 문제 해결
                // 내부적으로는 같은 JPQL
                .where(boardEntity.category.eq(category))
                .fetch();
    }

}
