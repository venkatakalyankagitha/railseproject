package com.railse.example.DTO;
import lombok.Data;
import java.util.List;

@Data
public class RateRequestDTO {
    private int sourcePincode;
    private int destPincode;
    private List<Box> boxes;
    private int paymentModeId;
    private double invoiceValue;
    private double codAmount;
    private int riskTypeId;

    @Data
    public static class Box {
        private String noofbox;
        private String boxlength;
        private String boxwidth;
        private String boxheight;
        private String boxdeadweight;
    }
}
