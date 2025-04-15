package com.railse.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.railse.example.entity.RateResponseEntity;

public interface RateResponseRepository extends JpaRepository<RateResponseEntity, Long> {
}
