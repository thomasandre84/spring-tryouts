package com.github.thommi.sb4.repo;

import com.github.thommi.sb4.model.Worktime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface WorktimeRepo extends JpaRepository<Worktime, UUID> {
}
