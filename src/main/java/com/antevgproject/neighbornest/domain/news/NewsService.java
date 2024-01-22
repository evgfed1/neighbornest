package com.antevgproject.neighbornest.domain.news;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class NewsService {

    @Resource
    public NewsMapper newsMapper;

    @Resource
    public NewsRepository newsRepository;

    public void createNews(NewsDTO newsDTO) {
        News news = newsMapper.newsFromNewsDTO(newsDTO);
        newsRepository.save(news);
    }
}
