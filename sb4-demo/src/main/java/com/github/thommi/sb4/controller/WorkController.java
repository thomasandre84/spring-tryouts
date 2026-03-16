package com.github.thommi.sb4.controller;

import com.github.thommi.sb4.model.Work;
import com.github.thommi.sb4.service.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/works")
public class WorkController {
    private WorkService workService;

    @Autowired
    public WorkController(WorkService workService) {
        this.workService = workService;
    }

    @PostMapping
    public Work newWork(String name) {
        return workService.createWork(name);
    }

}
