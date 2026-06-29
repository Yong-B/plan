package com.example.plan.controller;

import com.example.plan.domain.dto.PlanCreateRequestDto;
import com.example.plan.domain.dto.PlanDeleteDto;
import com.example.plan.domain.dto.PlanResponseDto;
import com.example.plan.domain.dto.PlanUpdateDto;
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
    @GetMapping("/{Id}")
    public ResponseEntity<PlanResponseDto> getPlan(
            @PathVariable Long Id
    ) {
        PlanResponseDto responseDto = planService.getPlan(Id);
        return ResponseEntity.ok(responseDto);
    }

    //일정 수정
    @PatchMapping("/{Id}")
    public ResponseEntity<PlanResponseDto> updatePlan(
            @PathVariable Long Id,
            @RequestBody PlanUpdateDto updateDto
    ) {
        return ResponseEntity.ok(planService.updateDto(Id, updateDto));
    }

    @DeleteMapping("/{Id}")
    public ResponseEntity<Void> deletePlan(
            @PathVariable Long Id,
            @RequestBody PlanDeleteDto deleteDto
    ) {
        planService.deletePlan(Id, deleteDto);
        return ResponseEntity.noContent().build();
    }
}