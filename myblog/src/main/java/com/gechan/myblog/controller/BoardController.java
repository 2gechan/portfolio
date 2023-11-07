package com.gechan.myblog.controller;

import com.gechan.myblog.models.BoardDto;
import com.gechan.myblog.models.CategoryVO;
import com.gechan.myblog.service.BoardService;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class BoardController {

    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("board")
    public String board(Model model, @RequestParam(required = false, value = "ca", defaultValue = "all") String category,
                        @RequestParam(required = false, defaultValue = "1") String page) {

        int pageNum = Integer.parseInt(page);
        List<BoardDto> boardList = new ArrayList<>();
        int pageCount = boardService.pageCount();
        if (category.equals("all")) {
            boardList = boardService.boardList(pageNum);

        } else {
            boardList = boardService.categoryBoardList(category);
        }
        List<CategoryVO> categoryList = boardService.categoryList();
        model.addAttribute("BOARDLIST", boardList);
        model.addAttribute("CATEGORY", categoryList);
        model.addAttribute("BODY", "BOARD");
        model.addAttribute("PAGE", pageCount);
        return "home";
    }

    @GetMapping("board/write")
    public String board_write(Model model) {

        model.addAttribute("BODY", "BOARD_WRITE");

        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("YYYY-MM-dd");
        String date = localDateTime.format(dateFormat);

        model.addAttribute("DATE", date);
        // System.out.println(date);
        return "home";
    }

    @PostMapping("board/write")
    public String board_write(BoardDto dto, Model model) {
        boardService.insert(dto);

        return "redirect:/board";
    }

    @GetMapping("board/detail")
    public String board_detail(@RequestParam(value = "seq") String b_seq, Model model) {
        long seq = Long.parseLong(b_seq);
        BoardDto dto = boardService.findById(seq);
        model.addAttribute("BOARD", dto);
        model.addAttribute("BODY", "BOARD_DETAIL");

        return "home";
    }

    @GetMapping("board/delete")
    public String delete(@RequestParam(value = "seq") String b_seq) {
        long seq = Long.parseLong(b_seq);
        boardService.delete(seq);

        return "redirect:/board";
    }

    @GetMapping("board/update")
    public String update(@RequestParam(value = "seq") String b_seq, Model model) {
        long seq = Long.parseLong(b_seq);
        BoardDto dto = boardService.findById(seq);

        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("YYYY-MM-dd");
        String date = localDateTime.format(dateFormat);
        dto.setB_date(date);

        model.addAttribute("BOARD", dto);
        model.addAttribute("BODY", "BOARD_UPDATE");
        return "home";
    }

    @PostMapping("board/update")
    public String update(BoardDto dto) {
        return "redirect:/";
    }
}
