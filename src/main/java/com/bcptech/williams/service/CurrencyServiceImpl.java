package com.bcptech.williams.service;

import com.bcptech.williams.Request.CurrencyRequest;
import com.bcptech.williams.Response.CurrencyResponse;
import com.bcptech.williams.entity.Currency;
import com.bcptech.williams.repository.CurrencyRepository;
import io.reactivex.Single;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class CurrencyServiceImpl implements CurrencyService{
    @Autowired
    private CurrencyRepository currencyRepository;

    @Override
    public Single<CurrencyResponse> findByOrigin(String origin) {

        return Single.create(singleSubscriber -> {
            Optional<Currency> optionalCurrency = currencyRepository.findCurrencyByOrigin(origin);
            if (!optionalCurrency.isPresent())
                singleSubscriber.onError(new EntityNotFoundException());
            else {
                CurrencyResponse currencyResponse = new CurrencyResponse();
                //CurrencyResponse currencyResponse = toBookResponse(optionalCurrency.get());


                BeanUtils.copyProperties(optionalCurrency.get(), currencyResponse);
                currencyResponse.setOrigin(currencyResponse.getOrigin());

                singleSubscriber.onSuccess(currencyResponse);
            }
        });
    }

    @Override
    public Single<CurrencyResponse> currencyExchangeByOrigin(CurrencyRequest currencyRequest) {

        return Single.create(singleSubscriber -> {
            Optional<Currency> optionalCurrency = currencyRepository.findCurrencyByOriginAndDestinity(currencyRequest.getOrigin(),currencyRequest.getDestinity());
            if (!optionalCurrency.isPresent())
                singleSubscriber.onError(new EntityNotFoundException());
            else {
                CurrencyResponse currencyResponse = new CurrencyResponse();
                Double amounTotal= currencyRequest.getAmount() * optionalCurrency.get().getExchangeRate();

                BeanUtils.copyProperties(optionalCurrency.get(), currencyResponse);
                currencyResponse.setAmount(currencyRequest.getAmount());
                currencyResponse.setAmounTotal(amounTotal);
                currencyResponse.setOrigin(currencyRequest.getOrigin());
                currencyResponse.setDestinity(currencyRequest.getDestinity());
                currencyResponse.setExchangeRate(optionalCurrency.get().getExchangeRate());


                singleSubscriber.onSuccess(currencyResponse);
            }
        });
    }

}
