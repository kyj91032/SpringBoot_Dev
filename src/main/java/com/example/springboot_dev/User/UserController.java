package com.example.springboot_dev.User;

import com.example.springboot_dev.Board.Data.BoardResponseDTO;
import com.example.springboot_dev.User.Data.UserPostCountDTO;
import com.example.springboot_dev.User.Data.UserRequestDTO;
import com.example.springboot_dev.User.Data.UserResponseDTO;
import com.example.springboot_dev.User.Data.UserSignUpDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/signup") // 회원가입 (유저 생성)
    public void signup(@RequestBody UserSignUpDTO userSignUpDTO) {
        // @RequestBody: HTTP 요청의 body 내용을 자바 객체로 매핑하는 역할 -> JSON 형태로 전달된 요청의 본문을 자바 객체로 변환
        // -> Controller에서 입력 데이터를 DTO 객채로 직접 입력받을 수 있음
        userService.signUp(userSignUpDTO);
    }

    @GetMapping("/login") // 로그인 (유저 조회)
    public void login(String email, String password) {
        userService.logIn(email, password);
    }

    @GetMapping("/posts/count") // 모든 유저의 게시글 개수 조회
    public List<UserPostCountDTO> getPostCount() {
        return userService.getPostCount();
    }

}
