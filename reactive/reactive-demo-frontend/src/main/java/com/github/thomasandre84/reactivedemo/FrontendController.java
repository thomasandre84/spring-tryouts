package com.github.thomasandre84.reactivedemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.SynchronousSink;

import java.time.LocalDateTime;

@RestController
@RequestMapping(FrontendController.BASE_URL)
public class FrontendController {
    static final String BASE_URL = "/frontend";

    @GetMapping("/stream")
    public Flux<String> getDateStream() {
        return Flux.generate(
                (SynchronousSink<String> syncSink) -> {
                    syncSink.next(LocalDateTime.now().toString());
                })
                .log();
    }
}
