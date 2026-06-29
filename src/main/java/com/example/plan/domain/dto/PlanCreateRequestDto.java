package com.example.plan.domain.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PlanCreateRequestDto {
    private String title;
    private String content;
    private String author;
    private String password;
}
