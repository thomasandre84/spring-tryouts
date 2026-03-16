package com.github.thommi.sb4.service;

import com.github.thommi.sb4.model.Work;
import com.github.thommi.sb4.repo.WorkRepo;
import com.github.thommi.sb4.repo.WorktimeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkService {
    private WorkRepo workRepo;
    private WorktimeRepo worktimeRepo;

    @Autowired
    public WorkService(WorkRepo workRepo, WorktimeRepo worktimeRepo) {
        this.workRepo = workRepo;
        this.worktimeRepo = worktimeRepo;
    }

    public Work createWork(String name) {
        Work work = new Work(name);
        return workRepo.save(work);
    }
}
