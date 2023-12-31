package com.example.springboot_dev.User;

import com.example.springboot_dev.User.Data.UserEntity;
import com.example.springboot_dev.User.Data.UserRequestDTO;
import com.example.springboot_dev.User.Data.UserResponseDTO;
import com.example.springboot_dev.User.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true) // 읽기 전용. 성능 최적화
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional // 생성이므로 readOnly = false
    public void signUp(UserRequestDTO userRequestDTO) {
        userRepository.save(userRequestDTO.toEntity()).getUid();
    }

    public void logIn(UserRequestDTO userRequestDTO) {
        UserEntity userEntity = userRepository.findByEmail(userRequestDTO.getEmail());
        if (userEntity == null) {
            throw new IllegalArgumentException("가입되지 않은 E-MAIL 입니다.");
            // IllegalArgumentException: 잘못된 인자를 전달했을 때 발생하는 예외
        } else if (!userEntity.getPassword().equals(userRequestDTO.getPassword())) {
            throw new IllegalArgumentException("잘못된 비밀번호입니다.");
        } else {
            System.out.println("로그인 성공");
        }
    }

}
