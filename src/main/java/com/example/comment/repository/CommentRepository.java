package com.example.comment.repository;

import com.example.comment.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    
    long countByPlanId(Long planId);
}
