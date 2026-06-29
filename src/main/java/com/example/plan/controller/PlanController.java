package com.example.plan.controller;

import com.example.plan.domain.dto.PlanCreateRequestDto;
import com.example.plan.domain.dto.PlanResponseDto;
import com.example.plan.service.PlanService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/plans")
@RequiredArgsConstructor
public class PlanController {
    private final PlanService planService;

    @PostMapping
    public ResponseEntity<PlanResponseDto> createPlan(
            @RequestBody PlanCreateRequestDto requestDto
    ) {
        PlanResponseDto responseDto = planService.createPlan(requestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
    }
}