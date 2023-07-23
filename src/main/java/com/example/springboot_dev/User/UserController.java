package com.example.springboot_dev.User;

import com.example.springboot_dev.User.Data.UserRequestDTO;
import com.example.springboot_dev.User.Data.UserResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/register") // 회원가입 (유저 생성)
    public Long register(String name, String pw) {
        return userService.register(new UserRequestDTO(name, pw));
    }

    @GetMapping("/find/{name}") // 회원 검색
    public UserResponseDTO getUserByName(@PathVariable("name") String name) {
        return userService.getUserByName(name);
    }

    @GetMapping("/list") // 회원 전체 조회
    public List<UserResponseDTO> getUserList() {
        return userService.getUserList(); // + 직렬화를 위해서 UserResponseDTO에 기본 생성자와 Getter/Setter 메서드 필요
    }

    @DeleteMapping("/delete/{id}") // 회원 삭제
    public void deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
    }

}
