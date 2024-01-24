package com.antevgproject.neighbornest.domain.news;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewsDTO {
    private Integer userId;
    private String title;
    private String content;
    private Instant publishDate;
    private String status;
    private LocalDate eventDate;

    @Override
    public String toString() {
        return "NewsDTO{" +
                "userId=" + userId +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", publishDate=" + publishDate +
                ", status='" + status + '\'' +
                ", eventDate='" + eventDate + '\'' +
                '}';
    }
}
