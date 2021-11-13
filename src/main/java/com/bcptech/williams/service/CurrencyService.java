package com.bcptech.williams.service;

import com.bcptech.williams.Request.CurrencyRequest;
import com.bcptech.williams.Response.CurrencyResponse;
import com.bcptech.williams.entity.Currency;
import io.reactivex.Single;

import java.util.List;

public interface CurrencyService {

    Single<CurrencyResponse> findByOrigin(String origin);
    Single<CurrencyResponse> currencyExchangeByOrigin(CurrencyRequest origin);
}
