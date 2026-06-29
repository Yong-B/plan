package com.example.plan.domain.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PlanUpdateDto {
    private String title;
    private String author;
    private String password;
}
