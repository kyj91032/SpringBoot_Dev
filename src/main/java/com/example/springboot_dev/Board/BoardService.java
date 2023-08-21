package com.example.springboot_dev.Board;

import com.example.springboot_dev.Board.Data.BoardEntity;
import com.example.springboot_dev.Board.Data.BoardRequestDTO;
import com.example.springboot_dev.Board.Data.BoardResponseDTO;
import com.example.springboot_dev.Board.Repository.BoardRepository;
import com.example.springboot_dev.Comment.Data.CommentResponseDTO;
import com.example.springboot_dev.User.Data.UserEntity;
import com.example.springboot_dev.User.Data.UserResponseDTO;
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
public class BoardService {

    private final BoardRepository boardRepository;
    private final UserRepository userRepository;

    public void saveBoard(BoardRequestDTO boardRequestDTO) {
        Optional<UserEntity> user = userRepository.findById(boardRequestDTO.getUid());
        if(user.isPresent()) {
            BoardEntity board = new BoardEntity(
                    boardRequestDTO.getTitle(),
                    boardRequestDTO.getBcontent(),
                    user.get()
            );
            boardRepository.save(board);
        }
    }

    public List<BoardResponseDTO> getBoardList() {
        List<BoardEntity> boardEntities = boardRepository.findAll();
        List<BoardResponseDTO> boardResponseDTOS = boardEntities.stream()
                .map(entity -> {
                    BoardResponseDTO dto = new BoardResponseDTO();
                    dto.setBid(entity.getBid());
                    dto.setTitle(entity.getTitle());
                    dto.setBcontent(entity.getBcontent());
                    dto.setUserResponseDTO(new UserResponseDTO(
                            entity.getUser().getUid(),
                            entity.getUser().getUname(),
                            entity.getUser().getPw())
                    );
//                    dto.setRecommend((int) recommendRepository.countByBid(entity.getBid()));
                    return dto;
                })
                .collect(Collectors.toList());
        return boardResponseDTOS;
    }

    public BoardResponseDTO getBoard(Long id) {
        Optional<BoardEntity> boardEntity = boardRepository.findByIdWithComments(id);

        if(boardEntity.isPresent()) {
            BoardEntity board = boardEntity.get();

            List<CommentResponseDTO> commentResponseDTOs = board.getComments().stream().
                map(comment -> {
                    CommentResponseDTO dto = new CommentResponseDTO();
                    dto.setCid(comment.getCid());
                    dto.setCcontent(comment.getCcontent());
                    return dto;
                }).collect(Collectors.toList());

            BoardResponseDTO boardResponseDTO = new BoardResponseDTO(
                board.getBid(),
                board.getTitle(),
                board.getBcontent(),
                new UserResponseDTO(
                        board.getUser().getUid(),
                        board.getUser().getUname(),
                        board.getUser().getPw()
                ),
                commentResponseDTOs,0
//                (int) recommendRepository.countByBid(board.getBid())
            );
            return boardResponseDTO;
        }
        return null;
    }



    public void deleteBoard(Long id) {
        boardRepository.deleteById(id);
    }

}
