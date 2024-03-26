package com.reactive.app;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

@SpringBootTest
class ReactiveProjectApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void workingWithMono(){
		// Created a Mono
//		Mono<String> error = Mono.error(new RuntimeException("Error !!"));
//		Mono<String> m1 = Mono
//				.just("Learn code with Keshav")
//				.log()
//				.then(error);
//
//		m1.subscribe(data->{
//			System.out.println("data is " + data);
//		});
//		error.subscribe(System.out::println);

////		zip is used to combine multiple Mono's we can use zipwith
////			which combines one Mone with another and returns a
////				combined Mono
//		Mono<String> m1 = Mono.just("Learn code with Keshav");
//		Mono<String>m2 = Mono.just("Subscribe to my channel");
//		Mono<Tuple2<String, String>> zip = Mono.zip(m1, m2);
//		zip.subscribe(data->{
//			System.out.println(data.getT1());
//			System.out.println(data.getT2());
//		});
		Mono<String> m1 = Mono.just("Learn Code With Keshav");
		Mono<String> m2 = Mono.just("Subscribe to my channel");
		Mono<String> m3 = Mono.just("Share With your Friends");

		Mono<String> resultMapMono = m1.map(String::toUpperCase);
		resultMapMono.subscribe(System.out::println);

		Mono<String[]> flatMono = m1.flatMap(valueM1 -> Mono.just(valueM1.split(" ")));
		flatMono.subscribe(data ->{
			for (String value : data){
				System.out.println(value);
			}
		});

		Flux<String> stringFlux = m1.flatMapMany(valueM1 -> Flux.just(valueM1.split(" ")));
		stringFlux.subscribe(System.out::println);
	}

}
