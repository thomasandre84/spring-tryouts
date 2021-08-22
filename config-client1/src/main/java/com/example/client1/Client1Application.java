package com.example.client1;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@SpringBootApplication
@RestController
public class Client1Application {

	public static void main(String[] args) {
		SpringApplication.run(Client1Application.class, args);
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseEntity<Mono<String>> hello() {
		return ResponseEntity.ok(Mono.just("Hello Client1"));
	}

}
