package com.example.springboot_dev.Comment;

import com.example.springboot_dev.Comment.Data.CommentRequestDTO;
import com.example.springboot_dev.Comment.Data.CommentResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    // 댓글 조회
//    @GetMapping(value = "/posts/{id}/comments")

    // 댓글 등록
//    @PostMapping(value = "/posts/{id}/comments")

    // 댓글 삭제
//    @DeleteMapping(value = "/posts/{id}/comments/{id}")

    // 댓글 수정
//    @PutMapping(value = "/posts/{id}/comments/{id}")

}
