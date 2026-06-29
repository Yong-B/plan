package com.example.plan.controller;

import com.example.plan.domain.dto.PlanCreateRequestDto;
import com.example.plan.domain.dto.PlanResponseDto;
import com.example.plan.service.PlanService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    //전체 조회
    @GetMapping
    public ResponseEntity<List<PlanResponseDto>> getPlans(
            @RequestParam(required = false) String author
    ) {
        List<PlanResponseDto> responseDtos = planService.getPlans(author);
        return ResponseEntity.ok(responseDtos);
    }

    //선택 조회
    @GetMapping("/{planId}")
    public ResponseEntity<PlanResponseDto> getPlan(
            @PathVariable Long planId
    ) {
        PlanResponseDto responseDto = planService.getPlan(planId);
        return ResponseEntity.ok(responseDto);
    }
}