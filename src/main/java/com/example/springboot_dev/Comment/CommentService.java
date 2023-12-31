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
    public void saveComment(CommentRequestDTO commentRequestDTO) {

        Optional<BoardEntity> board = boardRepository.findById(commentRequestDTO.getBid());
        Optional<UserEntity> user = userRepository.findById(commentRequestDTO.getUid());

        if(board.isPresent() && user.isPresent()) {
            commentRepository.save(new CommentEntity(
                    commentRequestDTO.getComment(),
                    commentRequestDTO.getCreatedAt(),
                    commentRequestDTO.getModifiedAt(),
                    user.get(),
                    board.get()
            ));
        }
    }

    public void updateComment(Long id, String comment) {
        Optional<CommentEntity> commentEntityWrapper = commentRepository.findById(id);
    }

    public void deleteComment(Long id) {
        commentRepository.deleteById(id);
    }

}
