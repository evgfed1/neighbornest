package com.antevgproject.neighbornest.domain.news;

import jakarta.annotation.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/news")
public class NewsController {

    @Resource
    private NewsService newsService;

    @PostMapping("/create")
    public ResponseEntity<String> createNews(@RequestBody NewsDTO newsDTO) {
        newsService.createNews(newsDTO);
        return ResponseEntity.ok("News created successfully");
    }
}
