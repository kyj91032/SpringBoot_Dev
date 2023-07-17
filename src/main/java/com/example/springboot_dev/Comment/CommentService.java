package com.example.springboot_dev.Comment;

import com.example.springboot_dev.Board.Data.BoardEntity;
import com.example.springboot_dev.Board.Repository.BoardRepository;
import com.example.springboot_dev.Comment.Data.CommentEntity;
import com.example.springboot_dev.Comment.Data.CommentRequestDTO;
import com.example.springboot_dev.Comment.Data.CommentResponseDTO;
import com.example.springboot_dev.Comment.Repository.CommentRepository;
import com.example.springboot_dev.User.Data.UserEntity;
import com.example.springboot_dev.User.Repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class CommentService {

    private final BoardRepository boardRepository;
    private  final CommentRepository commentRepository;

    public void saveComment(CommentRequestDTO commentRequestDTO) {

        Optional<BoardEntity> board = boardRepository.findById(commentRequestDTO.getBid());

        if (board.isPresent()) {
            CommentEntity commentEntity = new CommentEntity(
                    commentRequestDTO.getCcontent(),
                    board.get()
            );
            commentRepository.save(commentEntity);
        }
    }

    public List<CommentResponseDTO> getCommentList() {
        List<CommentEntity> commentEntities = commentRepository.findAll();
        List<CommentResponseDTO> commentResponseDTOs = commentEntities.stream()
                .map(entity -> {
                    CommentResponseDTO dto = new CommentResponseDTO();
                    dto.setCid(entity.getCid());
                    dto.setCcontent(entity.getCcontent());
                    return dto;
                })
                .collect(Collectors.toList());
        return commentResponseDTOs;
    }

    public void deleteComment(Long id) {
        commentRepository.deleteById(id);
    }

}
