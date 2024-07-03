package com.example.spring3.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
class HelloControllerTest {

    @Autowired
    WebTestClient webTestClient;

    @Test
    void hello() {
        webTestClient.get().uri("/hello")
                .exchange()
                .expectStatus().isOk()
                .expectBody(String.class).isEqualTo("Hello, World!");
    }

    @Test
    void add() {
        webTestClient.get().uri("/hello/add/3/5")
                .exchange()
                .expectStatus().isOk()
                .expectBody(String.class).isEqualTo("8");
    }
}