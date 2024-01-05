package com.example.springboot_dev.Board;

import com.example.springboot_dev.Board.Data.BoardEntity;
import com.example.springboot_dev.Board.Data.BoardRequestDTO;
import com.example.springboot_dev.Board.Data.BoardResponseDTO;
import com.example.springboot_dev.Board.Data.PostWithCommentDTO;
import com.example.springboot_dev.Board.Repository.BoardRepository;
import com.example.springboot_dev.Comment.Data.CommentEntity;
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

        // 예를 들어 boardEntities에 BoardEntity가 3개가 들어있고 uid 는 2개라면,
        // 처음에 boardEntity 리스트를 가져오는 쿼리를 1회 실행하고
        // 그 다음에 userEntity를 가져오는 쿼리를 2회 실행하게 됨
        // 이미 조회한 userEntity는 1차 캐시에 저장되어 있기 때문

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
            board.update(updatedContent);
            // 엔티티 클래스에서 setter 사용은 지양하는 것이 좋음 -> entity에 update 메소드를 만들어서 사용
            boardRepository.save(board);
            // JPA의 save 메소드는 엔터티의 식별자(ID)가 이미 존재하는 경우 해당 엔터티를 업데이트하고,
            // 그렇지 않은 경우에는 새로운 엔터티를 저장
        }
    }

    // 게시글 삭제 로직
    public void deletePost(Long id) {
        boardRepository.deleteById(id);
    }

    // 게시글 상세조회 로직 + 해당 게시글의 댓글 리스트 조회
    public PostWithCommentDTO getPost(Long id) {
        BoardEntity boardEntity = boardRepository.findByBidWithCommentList(id);
        // 이 경우는 findById를 해도 n+1 문제가 발생하지 않음 (findById 해도 쿼리 +1번 실행)
        // OneToMany 관계에서 findAll -> findAll 같은 경우에 쿼리가 n번 추가되는 n+1 문제가 발생함

        PostWithCommentDTO dto = PostWithCommentDTO.builder()
                .bid(boardEntity.getBid()) // 게시글 정보
                .title(boardEntity.getTitle())
                .content(boardEntity.getContent())
                .category(boardEntity.getCategory())
                .createdAt(boardEntity.getCreatedAt())
                .updatedAt(boardEntity.getUpdatedAt())
                .user(UserResponseDTO.builder() // 게시글 작성자 정보
                        .uid(boardEntity.getUser().getUid())
                        .userName(boardEntity.getUser().getUserName())
                        .password(boardEntity.getUser().getPassword())
                        .email(boardEntity.getUser().getEmail())
                        .createdAt(boardEntity.getUser().getCreatedAt())
                        .build()
                )
                .commentList(boardEntity.getCommentList().stream() // 게시글의 댓글 리스트
                        .map(commentEntity -> CommentResponseDTO.builder()
                                .cid(commentEntity.getCid())
                                .comment(commentEntity.getComment())
                                .createdAt(commentEntity.getCreatedAt())
                                .modifiedAt(commentEntity.getModifiedAt())
                                .build())
                        .collect(Collectors.toList()))
                .build();

        return dto;
    }
}
