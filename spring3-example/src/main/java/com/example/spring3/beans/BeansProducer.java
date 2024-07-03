package com.example.spring3.beans;

import com.example.spring3.utils.MathUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansProducer {

    @Bean
    public MathUtil mathUtil() {
        return new MathUtil();
    }

}
