package com.example.springboot_dev.User;

import com.example.springboot_dev.Board.Data.BoardResponseDTO;
import com.example.springboot_dev.User.Data.*;
import com.example.springboot_dev.User.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true) // 읽기 전용. 성능 최적화
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    // 회원가입 로직
    @Transactional // 생성이므로 readOnly = false(기본)로 설정
    public void signUp(UserSignUpDTO userSignUpDTO) {
        UserEntity userEntity = UserEntity.builder()
                .userName(userSignUpDTO.getUserName())
                .password(userSignUpDTO.getPassword())
                .email(userSignUpDTO.getEmail())
                .createdAt(LocalDateTime.now())
                .build();
        userRepository.save(userEntity);
    }

    // 로그인 로직
    public void logIn(String email, String password) {
        UserEntity userEntity = userRepository.findByEmail(email);
        if (userEntity == null) {
            System.out.println("존재하지 않는 이메일입니다.");
        } else if (!userEntity.getPassword().equals(password)) {
            System.out.println("잘못된 비밀번호입니다.");
        } else {
            System.out.println("로그인 성공");
        }
    }

    // 모든 유저의 게시글 개수 조회 로직
    public List<UserPostCountDTO> getPostCount() {
//        List<UserEntity> userEntities = userRepository.findAll();
        // 연관된 엔티티를 조회하지 않고 유저 리스트만 조회하는 쿼리를 실행
        // oneToMany의 패치 전략이 LAZY 이든 EAGER 이든 JPQL은 연관관계를 고려하지 않고 대상 엔티티만을 기준으로 쿼리를 실행하기 때문에
        // 추가 쿼리 발생 문제
        // 매 유저마다 게시글 리스트를 조회하는 쿼리가 실행됨

        List<UserEntity> userEntities = userRepository.findAllWithBoardList();
        // 연관된 엔티티까지 한번에 조회하는 쿼리를 실행하도록 해서 1차 캐시에 올림 (JPQL의 fetch join 사용)

        return userEntities.stream()
                .map(userEntity -> UserPostCountDTO.builder()
                        .userName(userEntity.getUserName())
                        .postCount(userEntity.getBoardList().size())
                        .build())
                .collect(Collectors.toList());
    }

}
