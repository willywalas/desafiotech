package com.bcptech.williams.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_currency")
public class Currency {

    private @Id
    @GeneratedValue
    Long id;
    private String origin;
    private String destinity;
    private Double exchangeRate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public Double getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(Double exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public String getDestinity() {
        return destinity;
    }

    public void setDestinity(String destinity) {
        this.destinity = destinity;
    }

}
