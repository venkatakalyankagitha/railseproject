package com.railse.example.DTO;

import lombok.Data;

@Data
public class RateResponseDTO {
    private boolean status;
    private String message;
    private Object data; 
}
