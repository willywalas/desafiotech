package com.bcptech.williams.controller;

import com.bcptech.williams.Request.CurrencyRequest;
import com.bcptech.williams.Response.CurrencyResponse;
import com.bcptech.williams.entity.Currency;
import com.bcptech.williams.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.Single;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
public class CurrencyController {

    @Autowired
    private CurrencyService currencyService;

    /*@PostMapping("/books")
    public ResponseEntity<?> newBook(@RequestBody Book newBook) throws URISyntaxException {

        bookService.save(newBook);
        Resource<Book> resource = assembler.toResource(newBook);

        return ResponseEntity
                .created(new URI(resource.getId().expand().getHref()))
                .body(resource);
    }*/

    /*@GetMapping("/currency/{origin}")
    public Resource<Currency> one(@PathVariable String origin) {

        Currency book = currencyService.findByOrigin(origin);

        return Resource<Currency> toResource(Currency book);;
    }*/

    @CrossOrigin(origins = "*")
    @GetMapping("/currency/{origin}")
    public Single<ResponseEntity<CurrencyResponse>> getCurrencyDetail(@PathVariable(value = "origin") String origin) {
        return currencyService.findByOrigin(origin)
                .subscribeOn(Schedulers.io())
                .map(ResponseEntity::ok);
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/currency/exchange")
    public Single<ResponseEntity<CurrencyResponse>> getCurrencyExChange(@RequestBody CurrencyRequest currencyRequest) {
        return currencyService.currencyExchangeByOrigin(currencyRequest)
                .subscribeOn(Schedulers.io())
                .map(ResponseEntity::ok);
    }
}
