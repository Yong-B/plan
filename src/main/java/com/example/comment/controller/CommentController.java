package com.example.comment.controller;

import com.example.comment.domain.dto.CommentCreateRequestDto;
import com.example.comment.domain.dto.CommentResponseDto;
import com.example.comment.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;


    @PostMapping("/api/plans/{planId}/comments")
    public ResponseEntity<CommentResponseDto> createComment(
            @PathVariable Long planId,
            @RequestBody CommentCreateRequestDto requestDto
            ){
        CommentResponseDto responseDto = commentService.createComment(planId, requestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
    }
}
