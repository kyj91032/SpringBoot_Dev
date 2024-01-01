package com.example.springboot_dev.Comment;

import com.example.springboot_dev.Board.Data.BoardEntity;
import com.example.springboot_dev.Board.Repository.BoardRepository;
import com.example.springboot_dev.Comment.Data.CommentEntity;
import com.example.springboot_dev.Comment.Data.CommentRequestDTO;
import com.example.springboot_dev.Comment.Data.CommentResponseDTO;
import com.example.springboot_dev.Comment.Repository.CommentRepository;
import com.example.springboot_dev.User.Data.UserEntity;
import com.example.springboot_dev.User.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class CommentService {

    private final BoardRepository boardRepository;
    private  final CommentRepository commentRepository;
    private final UserRepository userRepository;

    // 댓글 등록 로직
    public void saveComment(Long uid, Long pid, CommentRequestDTO commentRequestDTO) {

        Optional<BoardEntity> boardEntity= boardRepository.findById(pid);
        Optional<UserEntity> userEntity = userRepository.findById(uid);

        if(boardEntity.isPresent() && userEntity.isPresent()) {
            BoardEntity board = boardEntity.get();
            UserEntity user = userEntity.get();
            CommentEntity commentEntity = CommentEntity.builder()
                    .comment(commentRequestDTO.getComment())
                    .user(user)
                    .board(board)
                    .createdAt(LocalDateTime.now())
                    .modifiedAt(LocalDateTime.now())
                    .build();
            commentRepository.save(commentEntity);
        } else {
            System.out.println("댓글 등록 실패");
        }
    }

    public void updateComment(Long id, String comment) {
        Optional<CommentEntity> commentEntityWrapper = commentRepository.findById(id);
    }

    public void deleteComment(Long id) {
        commentRepository.deleteById(id);
    }

}
