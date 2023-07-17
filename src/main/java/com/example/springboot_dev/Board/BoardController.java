package com.example.springboot_dev.Board;

import com.example.springboot_dev.Board.Data.BoardRequestDTO;
import com.example.springboot_dev.Board.Data.BoardResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @PostMapping("/save") // 게시글 생성
    public void saveBoard(@RequestBody BoardRequestDTO boardRequestDTO) {
        boardService.saveBoard(boardRequestDTO);
    }

    @GetMapping("/list") // 게시글 전체 보기
    public List<BoardResponseDTO> getBoardList() {
        return boardService.getBoardList();
    }

    @GetMapping("/{id}") // 게시글 보기 - 게시글 정보, 유저 닉네임, 댓글 정보, 추천 수
    public BoardResponseDTO getBoard(@PathVariable("id") Long id) {
        return boardService.getBoard(id);
    }

    @DeleteMapping("/delete/{id}") // 게시글 삭제
    public void deleteBoard(@PathVariable("id") Long id) {
        boardService.deleteBoard(id);
    }


}
