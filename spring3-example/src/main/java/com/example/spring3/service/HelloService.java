package com.example.spring3.service;

import com.example.spring3.repository.HelloRepository;
import com.example.spring3.utils.MathUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("prototype")
public class HelloService {

    private final MathUtil mathUtil;

    private final HelloRepository helloRepository;

    @Autowired
    public HelloService(MathUtil mathUtil, HelloRepository helloRepository) {
        this.mathUtil = mathUtil;
        this.helloRepository = helloRepository;
    }

    public int add(int a, int b) {
        return mathUtil.add(a, b);
    }
}
