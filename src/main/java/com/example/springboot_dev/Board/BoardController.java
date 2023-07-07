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

    @PostMapping("/save") // create board
    public void saveBoard(@RequestBody BoardRequestDTO boardRequestDTO) {
        boardService.saveBoard(boardRequestDTO);
    }

    @GetMapping("/list") // read board
    public List<BoardResponseDTO> getBoardList() {
        return boardService.getBoardList();
    }

    @DeleteMapping("/delete/{id}") // delete board
    public void deleteBoard(@PathVariable("id") Long id) {
        boardService.deleteBoard(id);
    }


}
