package com.example.springboot_dev.Comment;

import com.example.springboot_dev.Comment.Data.CommentRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    // 댓글 등록
    @PostMapping(value = "/posts/comments")
    public void saveComment(@RequestBody CommentRequestDTO commentRequestDTO) {
        commentService.saveComment(commentRequestDTO);
    }

    // 댓글 삭제
    @DeleteMapping(value = "/posts/comments/{cid}")
    public void deleteComment(@PathVariable("cid") Long cid) {
        commentService.deleteComment(cid);
    }

    // 댓글 수정
    @PutMapping(value = "/posts/comments/{cid}")
    public void updateComment(@PathVariable("cid") Long cid, String updatedComment) {
        commentService.updateComment(cid, updatedComment);
    }

}
