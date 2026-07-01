package com.example.comment.domain.dto;

import com.example.comment.domain.Comment;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CommentResponseDto {
    private Long id;
    private Long planId;
    private String content;
    private String author;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    // 엔티티 객체를 DTO로 변환하는 생성자
    public CommentResponseDto(Comment comment) {
        this.id = comment.getId();
        this.planId = comment.getPlanId();
        this.content = comment.getContent();
        this.author = comment.getAuthor();
        this.createdAt = comment.getCreatedAt();
        this.modifiedAt = comment.getModifiedAt();
    }
}
