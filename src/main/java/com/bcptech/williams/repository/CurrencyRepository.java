package com.bcptech.williams.repository;

import com.bcptech.williams.entity.Currency;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CurrencyRepository extends JpaRepository<Currency, Long> {
    Optional<Currency> findCurrencyByOrigin(String origin);
    Optional<Currency> findCurrencyByOriginAndDestinity(String origin,String destinity);
}
