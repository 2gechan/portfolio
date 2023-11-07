package com.gechan.myblog.controller;

import com.gechan.myblog.models.BoardDto;
import com.gechan.myblog.models.ContentDto;
import com.gechan.myblog.service.ContentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Slf4j
@Controller
public class HomeController {

    private final ContentService contentService;
    public HomeController(ContentService contentService) {
        this.contentService = contentService;
    }

    @GetMapping("home")
    public String home() {
        return "home";
    }

    @GetMapping("intro")
    public String intro(Model model) {
        List<ContentDto> contentList = contentService.selectAll();
        log.debug("컨텐츠 : {}", contentList);
        model.addAttribute("CONTENTLIST", contentList);
        model.addAttribute("BODY", "INTRO");
        return "home";
    }

    @GetMapping("portfolio")
    public String portfolio(Model model) {
        model.addAttribute("BODY", "PORTFOLIO");
        return "home";
    }

    @GetMapping("update")
    public String update(String category, Model model) {
        if(category.equals("career")) {
            model.addAttribute("CATEGORY", "CAREER" );

        } else if (category.equals("edu")) {
            model.addAttribute("CATEGORY", "EDU");
        } else if(category.equals("cert")){
            model.addAttribute("CATEGORY", "CERT");
        }
        model.addAttribute("BODY", "UPDATE");

        return "home";
    }

    @PostMapping("update")
    public String update(ContentDto dto, Model model) {
        contentService.insert(dto);

        return "redirect:/intro";
    }


}
