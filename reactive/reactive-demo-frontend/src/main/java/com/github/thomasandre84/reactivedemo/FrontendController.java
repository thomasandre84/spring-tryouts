package com.github.thomasandre84.reactivedemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.SynchronousSink;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.concurrent.Callable;
import java.util.function.BiFunction;

@RestController
@RequestMapping(FrontendController.BASE_URL)
public class FrontendController {
    static final String BASE_URL = "/frontend";

    @GetMapping("/stream")
    public Flux<String> getDateStream() {

        //To supply an initial state
        Callable<String> initialState = () -> LocalDateTime.now().toString();

//BiFunction to consume the state, emit value, change state
        BiFunction<Integer, SynchronousSink<Character>, Integer> generator = (state, sink) -> {
            char value = (char) state.intValue();
            sink.next(value);
            if (value == 'Z') {
                sink.complete();
            }
            return state + 1;
        };

//Flux which accepts initialstate and bifunction as arg
       /* Flux<Character> charFlux = Flux.generate(initialState, generator);

//Observer
        charFlux.delayElements(Duration.ofMillis(50))
                .subscribe(i -> System.out.println("Consumed ::" + i));

        return Flux.generate(
                (SynchronousSink<String> syncSink) -> {
                    syncSink.next(LocalDateTime.now().toString());
                })
                .log();*/
        return null;
    }
}
