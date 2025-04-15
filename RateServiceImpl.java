package com.railse.example.service;
import java.util.List;

import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.railse.example.DTO.RateRequestDTO;
import com.railse.example.DTO.RateResponseDTO;
import com.railse.example.entity.RateResponseEntity;
import com.railse.example.repository.RateResponseRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RateServiceImpl implements RateService {

    private final RestTemplate restTemplate;
    private final RateResponseRepository rateResponseRepository;
    private final ObjectMapper objectMapper;

    private final String EXTERNAL_API = "https://appapinew.bigship.in/api/RateCalculate";

    @Override
    public RateResponseDTO calculateRate(RateRequestDTO request) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<RateRequestDTO> entity = new HttpEntity<>(request,headers);

        ResponseEntity<RateResponseDTO> response = restTemplate.exchange(EXTERNAL_API, HttpMethod.POST, entity, RateResponseDTO.class);

         RateResponseEntity responseEntity = new RateResponseEntity();
        responseEntity.setStatus(response.getBody().isStatus());
        responseEntity.setMessage(response.getBody().getMessage());
        try {
            String jsonData = objectMapper.writeValueAsString(response.getBody().getData());
            responseEntity.setDataJson(jsonData);
        } catch (Exception e) {
            responseEntity.setDataJson("Invalid JSON");
        }

        rateResponseRepository.save(responseEntity);
        return response.getBody();
    }
}
