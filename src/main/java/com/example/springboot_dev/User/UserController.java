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

    @PostMapping("/signup") // 회원가입 (유저 생성)
    public void signup(@RequestBody UserRequestDTO userRequestDTO) {
        // @RequestBody: HTTP 요청의 body 내용을 자바 객체로 매핑하는 역할 -> JSON 형태로 전달된 요청의 본문을 자바 객체로 변환
        // -> Controller에서 입력 데이터를 DTO 객채로 직접 입력받을 수 있음
        userService.signUp(userRequestDTO);
    }

    @PostMapping("/login") // 로그인 (유저 조회)
    public void login(@RequestBody UserRequestDTO userRequestDTO) {
        userService.logIn(userRequestDTO);
    }


}
