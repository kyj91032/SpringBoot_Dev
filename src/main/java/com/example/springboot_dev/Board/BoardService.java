package com.example.springboot_dev.Board;

import com.example.springboot_dev.Board.Data.BoardEntity;
import com.example.springboot_dev.Board.Data.BoardRequestDTO;
import com.example.springboot_dev.Board.Data.BoardResponseDTO;
import com.example.springboot_dev.Board.Repository.BoardRepository;
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
        List<BoardResponseDTO> boardResponseDTOS = boardEntities.stream()
                .map(entity -> {
                    BoardResponseDTO dto = BoardResponseDTO.builder()
                            .bid(entity.getBid())
                            .title(entity.getTitle())
                            .content(entity.getContent())
                            .category(entity.getCategory())
                            .createdAt(entity.getCreatedAt())
                            .updatedAt(entity.getUpdatedAt())
                            .user(UserResponseDTO.builder()
                                    .uid(entity.getUser().getUid())
                                    .userName(entity.getUser().getUserName())
                                    .password(entity.getUser().getPassword())
                                    .email(entity.getUser().getEmail())
                                    .createdAt(entity.getUser().getCreatedAt())
                                    .build()
                            )
                            .build();
                    return dto;
                })
                .collect(Collectors.toList());
        return boardResponseDTOS;
    }

    // 게시글 등록 로직
    public void savePost(BoardRequestDTO boardRequestDTO) {
        Optional<UserEntity> user = userRepository.findById(boardRequestDTO.getUid()); // uid로 userEntity 찾기
        if(user.isPresent()) { // findById는 Optional로 반환하기 때문에 isPresent()로 null 체크
            BoardEntity board = BoardEntity.builder()
                    .title(boardRequestDTO.getTitle())
                    .content(boardRequestDTO.getContent())
                    .category(boardRequestDTO.getCategory())
                    .createdAt(LocalDateTime.now())
                    .updatedAt(LocalDateTime.now())
                    .user(user.get())
                    .build();
            boardRepository.save(board);
        } else {
            System.out.println("해당 유저가 존재하지 않습니다.");
        }
    }

    // 게시글 수정 로직
    public void updatePost(Long id, String updatedContent) {
        Optional<BoardEntity> boardEntity = boardRepository.findById(id);
        if(boardEntity.isPresent()) {
            BoardEntity board = boardEntity.get();
            board.setContent(updatedContent);
            board.setUpdatedAt(LocalDateTime.now());
            boardRepository.save(board);
            // JPA의 save 메소드는 엔터티의 식별자(ID)가 이미 존재하는 경우 해당 엔터티를 업데이트하고,
            // 그렇지 않은 경우에는 새로운 엔터티를 저장

            // 엔티티 클래스에서 setter 사용은 지양해야 함
            // 수정 필요
        }
    }

    // 게시글 삭제 로직
    public void deletePost(Long id) {
        boardRepository.deleteById(id);
    }

    // 게시글 상세조회 로직
    public BoardResponseDTO getPost(Long id) {
        Optional<BoardEntity> boardEntity = boardRepository.findById(id);
        if(boardEntity.isPresent()) {
            BoardEntity board = boardEntity.get();
            BoardResponseDTO boardResponseDTO = BoardResponseDTO.builder()
                    .bid(board.getBid())
                    .title(board.getTitle())
                    .content(board.getContent())
                    .category(board.getCategory())
                    .createdAt(board.getCreatedAt())
                    .updatedAt(board.getUpdatedAt())
                    .user(new UserResponseDTO(
                                    board.getUser().getUid(),
                                    board.getUser().getUserName(),
                                    board.getUser().getPassword(),
                                    board.getUser().getEmail(),
                                    board.getUser().getCreatedAt()
                            )
                    )
                    .build();
            return boardResponseDTO;
        } else {
            return null;
        }
    }
}
