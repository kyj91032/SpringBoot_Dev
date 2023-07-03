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

    @PostMapping("/register") // Create user
    public void userRegister(String name, String pw) {
        userService.UserRegister(new UserRequestDTO(name, pw));
    }

    @GetMapping("/userlist") // Read user
    public List<UserResponseDTO> getUserList() {
        return userService.getUserList(); // + 직렬화를 위해서 UserResponseDTO에 기본 생성자와 Getter/Setter 메서드 필요
    }

    @DeleteMapping("/deleteuser/{id}") // Delete user
    public void deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
    }

}
