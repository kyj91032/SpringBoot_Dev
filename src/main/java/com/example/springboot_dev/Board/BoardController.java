package com.example.springboot_dev.Board;

import com.example.springboot_dev.Board.Data.BoardRequestDTO;
import com.example.springboot_dev.Board.Data.BoardResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    // 전체 페이지

    @GetMapping("/board/posts") // 전체 게시글 조회
    public List<BoardResponseDTO> getBoardList() {
        return boardService.getBoardList();
    }

    @PostMapping("/board/posts") // 게시글 등록
    public void saveBoard(@RequestBody BoardRequestDTO boardRequestDTO) {
        boardService.saveBoard(boardRequestDTO);
    }

    @PutMapping("/board/posts/{id}") // 게시글 수정
    public void updateBoard(@PathVariable("id") Long id, @RequestBody BoardRequestDTO boardRequestDTO) {
        // 게시글 수정 위한 dto 만들어야함
    }

    @DeleteMapping("/board/posts/{id}") // 게시글 삭제
    public void deleteBoard(@PathVariable("id") Long id) {
        boardService.deleteBoard(id);
    }

//    @GetMapping("/board/posts/{id}") // 게시글 상세조회
//    public BoardResponseDTO getBoard(@PathVariable("id") Long id) {
//        return boardService.getBoard(id);
//    }


}
