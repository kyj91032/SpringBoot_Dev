package com.example.springboot_dev.Comment.Repository;

import com.example.springboot_dev.Comment.Data.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<CommentEntity, Long> {

}
