package com.reactive.app.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;
import reactor.util.function.Tuple2;

@SpringBootTest
class FluxLearnTest {
    @Autowired
    private FluxLearnService fluxLearnService;
    @Test
    void filterExampleFlux() {
        Flux<String> filteredFlux = this.fluxLearnService.filterExampleFlux();
        StepVerifier.create(filteredFlux)
                .expectNextCount(3)
                .verifyComplete();
    }

    @Test
    void flatMapExampleFlux() {
        Flux<String> stringFlux = this.fluxLearnService.flatMapExampleFlux();
        StepVerifier.create(stringFlux)
                .expectNextCount(4)
                .verifyComplete();
    }

    @Test
    void transformExample() {
        Flux flux = this.fluxLearnService.transformExample();
        StepVerifier.create(flux)
                .expectNextCount(4)
                .verifyComplete();
    }

    @Test
    void ifExample() {
        Flux<String> stringFlux = this.fluxLearnService.ifExample(8);
        StepVerifier.create(stringFlux)
                .expectNextCount(2)
                .verifyComplete();
    }

    @Test
    void getZip() {
        Flux<Tuple2<String,Integer>> tuple2Flux = this.fluxLearnService.getZip().log();
        StepVerifier.create(tuple2Flux)
                .expectNextCount(4)
                .verifyComplete();
    }
}