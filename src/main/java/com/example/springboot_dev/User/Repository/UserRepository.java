package com.example.springboot_dev.User.Repository;

import com.example.springboot_dev.User.Data.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity, Long>, UserCustomRepository {

    UserEntity findByEmail(String email);

    @Query("SELECT u FROM UserEntity u LEFT JOIN FETCH u.boardList")
    List<UserEntity> findAllWithBoardList();



}
