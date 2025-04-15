package com.railse.example.service;

import com.railse.example.DTO.RateRequestDTO;
import com.railse.example.DTO.RateResponseDTO;

public interface RateService {
    RateResponseDTO calculateRate(RateRequestDTO request);
}
