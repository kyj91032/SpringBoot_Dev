package com.example.springboot_dev.User;

import com.example.springboot_dev.User.Data.UserEntity;
import com.example.springboot_dev.User.Data.UserRequestDTO;
import com.example.springboot_dev.User.Data.UserResponseDTO;
import com.example.springboot_dev.User.Repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public void UserRegister(UserRequestDTO userRequestDTO) {
        userRepository.save(userRequestDTO.toEntity());
    }

    public List<UserResponseDTO> getUserList() {
        List<UserEntity> userEntities = userRepository.findAll();
        List<UserResponseDTO> userResponseDTOs = userEntities.stream()
                .map(entity -> {
                    UserResponseDTO dto = new UserResponseDTO();
                    dto.setId(entity.getId());
                    dto.setName(entity.getName());
                    dto.setPw(entity.getPw());
                    return dto;
                })
                .collect(Collectors.toList()); // return List<>

        return userResponseDTOs;
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
