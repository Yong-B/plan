package com.example.plan.domain.dto;

import com.example.plan.domain.Plan;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PlanResponseDto {
    private final Long id;
    private final String title;
    private final String content;
    private final String author;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;

    public PlanResponseDto(Plan plan) {
        this.id = plan.getId();
        this.title = plan.getTitle();
        this.content = plan.getContent();
        this.author = plan.getAuthor();
        this.createdAt = plan.getCreatedAt();
        this.modifiedAt = plan.getModifiedAt();
    }
}
