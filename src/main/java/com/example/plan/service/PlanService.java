package com.example.plan.service;

import com.example.plan.domain.Plan;
import com.example.plan.domain.dto.PlanCreateRequestDto;
import com.example.plan.domain.dto.PlanDeleteDto;
import com.example.plan.domain.dto.PlanResponseDto;
import com.example.plan.domain.dto.PlanUpdateDto;
import com.example.plan.repository.PlanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    @Transactional(readOnly = true)
    public List<PlanResponseDto> getPlans(String author) {
        List<Plan> plans;

        if (author == null || author.isBlank()) {
            plans = planRepository.findAllByOrderByModifiedAtDesc();
        } else {
            plans = planRepository.findAllByAuthorOrderByModifiedAtDesc(author);
        }

        return plans.stream()
                .map(PlanResponseDto::new)
                .toList();
    }

    @Transactional(readOnly = true)
    public PlanResponseDto getPlan(Long planId) {
        Plan plan = planRepository.findById(planId)
                .orElseThrow(() -> new IllegalArgumentException("일정을 찾을 수 없습니다."));

        return new PlanResponseDto(plan);
    }

    @Transactional
    public PlanResponseDto updateDto(Long id, PlanUpdateDto updateDto) {
        Plan plan = planRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("일정을 찾을 수 없습니다."));

        if (plan.isPasswordMismatch(updateDto.getPassword())) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }

        plan.update(updateDto.getTitle(), updateDto.getAuthor());

        return new PlanResponseDto(plan);
    }

    @Transactional
    public void deletePlan(Long Id, PlanDeleteDto deleteDto) {
        Plan plan = planRepository.findById(Id)
                .orElseThrow(() -> new IllegalArgumentException("일정을 찾을 수 없습니다."));

        plan.validatePassword(deleteDto.getPassword());

        planRepository.delete(plan);
                
    }
}
