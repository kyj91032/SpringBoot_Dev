package com.example.springboot_dev.Board;

import com.example.springboot_dev.Board.Data.BoardEntity;
import com.example.springboot_dev.Board.Data.BoardRequestDTO;
import com.example.springboot_dev.Board.Data.BoardResponseDTO;
import com.example.springboot_dev.Board.Repository.BoardRepository;
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
public class BoardService {

    private final BoardRepository boardRepository;
    private final UserRepository userRepository;

    public void saveBoard(BoardRequestDTO boardRequestDTO) {
        Optional<UserEntity> user = userRepository.findById(boardRequestDTO.getUid());
        if(user.isPresent()) {
            BoardEntity board = new BoardEntity(
                    boardRequestDTO.getBname(),
                    boardRequestDTO.getContent(),
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
                    dto.setBname(entity.getBname());
                    dto.setContent(entity.getContent());
                    dto.setUid(entity.getUser().getUid());
                    dto.setUname(entity.getUser().getUname());
                    dto.setPw(entity.getUser().getPw());
                    return dto;
                })
                .collect(Collectors.toList());
        return boardResponseDTOS;
    }

    public void deleteBoard(Long id) {
        boardRepository.deleteById(id);
    }

}
