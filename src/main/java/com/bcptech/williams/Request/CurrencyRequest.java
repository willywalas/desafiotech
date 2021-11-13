package com.bcptech.williams.Request;

import lombok.Data;

@Data
public class CurrencyRequest {
    private Double amount;
    private String origin;
    private String destinity;

}
