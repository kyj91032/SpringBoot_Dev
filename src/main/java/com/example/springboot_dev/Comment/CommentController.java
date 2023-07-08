package com.example.springboot_dev.Comment;

import com.example.springboot_dev.Comment.Data.CommentRequestDTO;
import com.example.springboot_dev.Comment.Data.CommentResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/comment")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping(value = "/save") // create comment
    public void saveComment(@RequestBody CommentRequestDTO commentRequestDTO) {
        commentService.saveComment(commentRequestDTO);
    }

    @GetMapping(value = "/list") // read comment
    public List<CommentResponseDTO> getCommentList() {
        return commentService.getCommentList();
    }

    @DeleteMapping(value = "/delete/{id}") // delete comment
    public void deleteComment(@PathVariable("id") Long id) {
        commentService.deleteComment(id);
    }

}
