package com.example.comment.service;

import com.example.comment.domain.Comment;
import com.example.comment.domain.dto.CommentCreateRequestDto;
import com.example.comment.domain.dto.CommentResponseDto;
import com.example.comment.repository.CommentRepository;
import com.example.plan.repository.PlanRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final PlanRepository planRepository;

    @Transactional
    public CommentResponseDto createComment(Long planId, CommentCreateRequestDto requestDto) {
        if (!planRepository.existsById(planId)) {
            throw new IllegalArgumentException("해당 일정이 없습니다!");
        }

        long commentCount = commentRepository.countByPlanId(planId);
        if (commentCount >= 10) {
            throw new IllegalArgumentException("댓글은 10개까지만 작성할 수 있습니다.");
        }

        Comment comment = new Comment(
                planId,
                requestDto.getContent(),
                requestDto.getAuthor(),
                requestDto.getPassword()
        );

        Comment savedComment = commentRepository.save(comment);
        return new CommentResponseDto(savedComment);
    }
}