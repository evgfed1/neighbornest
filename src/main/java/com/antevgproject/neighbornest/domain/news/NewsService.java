package com.antevgproject.neighbornest.domain.news;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class NewsService {

    @Resource
    public NewsMapper newsMapper;

    @Resource
    public NewsRepository newsRepository;

    public void createNews(NewsDTO newsDTO) {
        News news = newsMapper.newsFromNewsDTO(newsDTO);
        news.setPublishDate(Instant.now());
        newsRepository.save(news);
    }
}
