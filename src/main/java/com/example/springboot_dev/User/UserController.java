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
    public Long signup(@RequestBody UserRequestDTO userRequestDTO) {
        // @RequestBody: HTTP 요청의 body 내용을 자바 객체로 매핑하는 역할 -> JSON 형태로 전달된 요청의 본문을 자바 객체로 변환
        // -> Controller에서 DTO를 직접 입력받을 수 있다는 것
        return userService.signup(userRequestDTO);
    }

    // 로그인 후 전체 페이지 /login


    // 로그아웃 후 전체 페이지 /logout


}
