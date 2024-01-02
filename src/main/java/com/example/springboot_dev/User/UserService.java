package com.example.springboot_dev.User;

import com.example.springboot_dev.User.Data.UserEntity;
import com.example.springboot_dev.User.Data.UserRequestDTO;
import com.example.springboot_dev.User.Data.UserResponseDTO;
import com.example.springboot_dev.User.Data.UserSignUpDTO;
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

}
