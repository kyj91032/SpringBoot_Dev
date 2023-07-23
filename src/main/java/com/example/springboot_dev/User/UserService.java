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
    public Long register(UserRequestDTO userRequestDTO) {
        return userRepository.save(userRequestDTO.toEntity()).getUid();
    }

    public UserResponseDTO getUserByName(String name) { // 회원 검색
        UserEntity userEntity = userRepository.findByUname(name); // Optional을 요구하지 않음
        if (userEntity != null) {
            return new UserResponseDTO(userEntity.getUid(), userEntity.getUname(), userEntity.getPw());
        } else {
            return null;
        }
    }

    public List<UserResponseDTO> getUserList() { // 회원 전체 조회
        List<UserEntity> userEntities = userRepository.findAll();
        List<UserResponseDTO> userResponseDTOs = userEntities.stream()
                .map(entity -> {
                    UserResponseDTO dto = new UserResponseDTO();
                    dto.setUid(entity.getUid());
                    dto.setUname(entity.getUname());
                    dto.setPw(entity.getPw());
                    return dto;
                })
                .collect(Collectors.toList()); // return List<>

        return userResponseDTOs;
    }

    public void deleteUser(Long uid) { // 회원 삭제
        userRepository.deleteById(uid);
    }
}
