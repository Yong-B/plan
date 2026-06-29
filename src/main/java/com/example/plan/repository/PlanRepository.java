package com.example.plan.repository;

import com.example.plan.domain.Plan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlanRepository extends JpaRepository<Plan, Long> {
    List<Plan> findAllByOrderByModifiedAtDesc();

    List<Plan> findAllByAuthorOrderByModifiedAtDesc(String author);

    Long id(Long id);
}
