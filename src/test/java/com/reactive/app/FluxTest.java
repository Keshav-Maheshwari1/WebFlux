package com.reactive.app;

import com.reactive.app.services.FluxLearnService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

@SpringBootTest
public class FluxTest {
    @Autowired
    private FluxLearnService fluxLearnService;
    @Test
    public void simpleFluxTest(){
//        this.fluxLearnService.getFlux().subscribe(data->{
//            System.out.println(data);
//            System.out.println("done");
//        });
        this.fluxLearnService.getFruits().subscribe(System.out::println);
    }
    @Test
    public void mapTest(){
        Flux<String> capFlux = this.fluxLearnService.mapExampleFlux();
        StepVerifier.create(capFlux)
                .expectNext("Keshav".toUpperCase(), "dev".toUpperCase(), "ragini".toUpperCase(), "sanjeev".toUpperCase())
                .verifyComplete();
    }
}
