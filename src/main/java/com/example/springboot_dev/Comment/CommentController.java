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

    // 전체 댓글 조회 -> boardService에서 join 하여 조회

    // 댓글 등록
    @PostMapping(value = "/posts/{id}/comments")
    public void saveComment(@RequestBody CommentRequestDTO commentRequestDTO) {
        commentService.saveComment(commentRequestDTO);
    }

    // 댓글 삭제
    @DeleteMapping(value = "/posts/comments/{id}")
    public void deleteComment(@PathVariable("id") Long id) {
        commentService.deleteComment(id);
    }

    // 댓글 수정
    @PutMapping(value = "/posts/comments/{id}")
    public void updateComment(@PathVariable("id") Long id, @RequestBody String comment) {
        commentService.updateComment(id, comment);
    }


}
