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

    @Transactional // 생성이므로 readOnly X
    public Long signup(UserRequestDTO userRequestDTO) {
        return userRepository.save(userRequestDTO.toEntity()).getUid();
    }

}
