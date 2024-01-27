package com.example.springboot_dev.Board;

import com.example.springboot_dev.Board.Data.BoardRequestDTO;
import com.example.springboot_dev.Board.Data.BoardResponseDTO;
import com.example.springboot_dev.Board.Data.PostWithCommentDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
// Thymeleaf는 템플릿(뷰)를 반환하기 때문에 @RestController가 아닌 @Controller를 사용한다(@ResponseBody를 뺀다)
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

//    @GetMapping("/posts") // 전체 게시글 조회
//    public List<BoardResponseDTO> getPostList() {
//        return boardService.getPostList();
//    }

    @GetMapping("/posts")
    public String getPostList(Model model) { // 전체 게시글 조회 - Thymeleaf
        List<BoardResponseDTO> postList = boardService.getPostList();
        model.addAttribute("postList", postList);
        return "post";
    }

    @PostMapping("/posts") // 게시글 등록
    public void savePost(@RequestBody BoardRequestDTO boardRequestDTO) {
        boardService.savePost(boardRequestDTO);
    }

    @PutMapping("/posts/{id}") // 게시글 수정
    public void updateBoard(@PathVariable("id") Long id, String updatedContent) {
        boardService.updatePost(id, updatedContent);
    }

    @DeleteMapping("/posts/{id}") // 게시글 삭제
    public void deleteBoard(@PathVariable("id") Long id) {
        boardService.deletePost(id);
    }

    @GetMapping("/posts/{id}") // 게시글 상세조회
    public PostWithCommentDTO getPost(@PathVariable("id") Long id) {
        return boardService.getPost(id);
    }

    @GetMapping("/posts/category/{category}") // 카테고리별 게시글 조회
    public List<BoardResponseDTO> getPostListByCategory(@PathVariable("category") String category) {
        return boardService.getPostListByCategory(category);
    }

}
