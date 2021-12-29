package com.github.thomasandre84.client1;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class RestAPI {

    @Value("${test.message}")
    String message;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<Mono<String>> hello() {
        return ResponseEntity.ok(Mono.just("Hello Client1 with Message: " + message));
    }

}
