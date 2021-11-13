package com.bcptech.williams.Response;

import lombok.Data;

@Data
public class CurrencyResponse {
    private String origin;
    private String destinity;
    private Double amount;
    private Double amounTotal;
    private Double exchangeRate;
}
