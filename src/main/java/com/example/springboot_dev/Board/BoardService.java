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

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;
    private final UserRepository userRepository;

    // 전체 게시글 조회 로직
    public List<BoardResponseDTO> getPostList() {
        List<BoardEntity> boardEntities = boardRepository.findAll();
        // n+1 문제
        List<BoardResponseDTO> boardResponseDTOS = boardEntities.stream()
                .map(entity -> {
                    BoardResponseDTO dto = new BoardResponseDTO();
                    dto.setBid(entity.getBid());
                    dto.setTitle(entity.getTitle());
                    dto.setContent(entity.getContent());
                    dto.setCategory(entity.getCategory());
                    dto.setCreatedAt(entity.getCreatedAt());
                    dto.setUpdatedAt(entity.getUpdatedAt());
                    dto.setUser(new UserResponseDTO(
                                    entity.getUser().getUid(),
                                    entity.getUser().getUserName(),
                                    entity.getUser().getPassword(),
                                    entity.getUser().getEmail(),
                                    entity.getUser().getCreatedAt()
                            )
                    );
                    return dto;
                })
                .collect(Collectors.toList());
        return boardResponseDTOS;
    }

    // 게시글 등록 로직
    public void saveBoard(BoardRequestDTO boardRequestDTO) {
        Optional<UserEntity> user = userRepository.findById(boardRequestDTO.getUid()); // uid로 userEntity 찾기
        if(user.isPresent()) { // findById는 Optional로 반환하기 때문에 isPresent()로 null 체크
            BoardEntity board = BoardEntity.builder() // toEntity 가 아닌 service에서 직접 만듦
                    .title(boardRequestDTO.getTitle())
                    .content(boardRequestDTO.getContent())
                    .category(boardRequestDTO.getCategory())
                    .createdAt(LocalDateTime.now())
                    .updatedAt(LocalDateTime.now())
                    .user(user.get())
                    .build();
            boardRepository.save(board);
        }
    }

    // 게시글 수정 로직


    public void deleteBoard(Long id) {
        boardRepository.deleteById(id);
    }

    // 게시글 상세조회 로직 // comment 랑 조인 필요
//    public BoardResponseDTO getBoard(Long id) {
//        Optional<BoardEntity> boardEntity = boardRepository.findByIdWithComments(id);
//
//        if(boardEntity.isPresent()) {
//            BoardEntity board = boardEntity.get();
//
//            List<CommentResponseDTO> commentResponseDTOs = board.getComments().stream().
//                map(comment -> {
//                    CommentResponseDTO dto = new CommentResponseDTO();
//                    dto.setCid(comment.getCid());
//                    dto.setCcontent(comment.getCcontent());
//                    return dto;
//                }).collect(Collectors.toList());
//
//            BoardResponseDTO boardResponseDTO = new BoardResponseDTO(
//                board.getBid(),
//                board.getTitle(),
//                board.getBcontent(),
//                new UserResponseDTO(
//                        board.getUser().getUid(),
//                        board.getUser().getUname(),
//                        board.getUser().getPw()
//                ),
//                commentResponseDTOs,0
////                (int) recommendRepository.countByBid(board.getBid())
//            );
//            return boardResponseDTO;
//        }
//        return null;
//    }

}
