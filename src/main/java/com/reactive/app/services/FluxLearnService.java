package com.reactive.app.services;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.util.function.Tuple2;

import java.time.Duration;
import java.util.List;
import java.util.function.Function;

@Service
public class FluxLearnService {
    // All operators Go Here

    // For creating a flux of strings
    public Flux<String> getFlux(){
        return Flux.just("Keshav", "dev", "ragini", "sanjeev");
    }

    // Creating a Flux using iterator
    public Flux<String> getFruits(){
        List<String> list = List.of("Apple", "Mango");
        return Flux.fromIterable(list);
    }

    // Crating an Empty Flux
    public Flux<Void> getEmpty(){
        return Flux.empty();
    }

    // Map
    public Flux<String> mapExampleFlux(){
        return getFlux().map(String::toUpperCase).log();
    }

    // Filter
    public Flux<String> filterExampleFlux(){
        return getFlux().filter(name->name.length()>4).log();
    }

    // FlatMap and Delay
    public Flux<String> flatMapExampleFlux(){
//        return getFlux().flatMap(name -> Flux.just(name.split(" ")));
        return getFlux().flatMap(name->Flux.just("Test FLux")).delayElements(Duration.ofSeconds(2)).log();
    }

    // transform example
    public Flux transformExample(){
    Function<Flux<String>,Flux<String>> funInteface = (name)->name.map(String::toUpperCase);
        return getFlux().transform(funInteface).log();
    }
    // defaultIfEmpty
    // switchIfEmpty
    public Flux<String> ifExample(int length){
        return getFlux()
                .filter(name-> name.length()>length )
//                .defaultIfEmpty("No Name")
                .switchIfEmpty(getFruits())
                .log();
    }

    // Zip and ZipWith Example
    public Flux<Tuple2<String,Integer>> getZip(){
        return Flux.zip(getFlux(),Flux.just(1,2,3,4));
    }



}
