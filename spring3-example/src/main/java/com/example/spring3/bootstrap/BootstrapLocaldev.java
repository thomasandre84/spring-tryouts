package com.example.spring3.bootstrap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;


@Profile("localdev")
@Configuration
public class BootstrapLocaldev implements CommandLineRunner {

    static final Logger LOGGER = LoggerFactory.getLogger(BootstrapLocaldev.class);

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Local Dev Bootstrap");
        LOGGER.info("Local Dev Bootstrap");
    }
}
