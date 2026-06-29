package com.example.plan.service;

import com.example.plan.domain.Plan;
import com.example.plan.domain.dto.PlanCreateRequestDto;
import com.example.plan.domain.dto.PlanResponseDto;
import com.example.plan.repository.PlanRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PlanService {
    private final PlanRepository planRepository;

    @Transactional
    public PlanResponseDto createPlan(PlanCreateRequestDto requestDto) {
        Plan plan = new Plan(
                requestDto.getTitle(),
                requestDto.getContent(),
                requestDto.getAuthor(),
                requestDto.getPassword()
        );

        Plan savedPlan = planRepository.save(plan);

        return new PlanResponseDto(savedPlan);
    }
}
