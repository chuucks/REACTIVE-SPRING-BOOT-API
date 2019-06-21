package com.codesolt.springbootreactive.service;

import com.codesolt.springbootreactive.model.Coins;
import com.codesolt.springbootreactive.model.SingleTicker;
import com.codesolt.springbootreactive.model.Tickers;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@Profile("test")
public class CoinServiceStub implements CoinService {

    @Override
    public Mono<Coins> getCoins() {
        return Mono.just(Coins
                .builder()
                .success("true")
                .build());
    }

    @Override
    public Mono<SingleTicker> getTicker(String id) {
        return Mono.just(SingleTicker
                .builder()
                .success("true")
                .build());
    }

    @Override
    public Mono<Tickers> getTickers() {
        return Mono.just(Tickers
                .builder()
                .success("true")
                .build());
    }
}
