package com.example.springboot_dev.Comment;

import com.example.springboot_dev.Comment.Data.CommentRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    // 댓글 등록
    @PostMapping(value = "/posts/{id}/comments")
    public void saveComment(@RequestParam Long uid, @PathVariable("id") Long pid, @RequestBody CommentRequestDTO commentRequestDTO) {
        commentService.saveComment(uid, pid, commentRequestDTO);
    }

    // 댓글 삭제
//    @DeleteMapping(value = "/posts/{id}/comments/{id}")

    // 댓글 수정
//    @PutMapping(value = "/posts/{id}/comments/{id}")

}
