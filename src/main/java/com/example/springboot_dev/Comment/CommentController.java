package com.example.springboot_dev.Comment;

import com.example.springboot_dev.Comment.Data.CommentRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    // 댓글 등록
    @PostMapping(value = "/posts/{pid}/comments")
    public void saveComment(@RequestParam Long uid, @PathVariable("pid") Long pid, @RequestBody CommentRequestDTO commentRequestDTO) {
        commentService.saveComment(uid, pid, commentRequestDTO);
    }

    // 댓글 삭제
    @DeleteMapping(value = "/posts/{pid}/comments/{cid}")
    public void deleteComment(@PathVariable("cid") Long cid, @PathVariable String pid) {
        commentService.deleteComment(cid);
    }

    // 댓글 수정
    @PutMapping(value = "/posts/{pid}/comments/{cid}")
    public void updateComment(@PathVariable("cid") Long cid, @PathVariable("pid") Long pid, @RequestBody CommentRequestDTO commentRequestDTO) {
        commentService.updateComment(cid, commentRequestDTO);
    }

}
