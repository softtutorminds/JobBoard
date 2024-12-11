package com.pranay.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.pranay.model.Job;

public interface JobRepository extends JpaRepository<Job, Long> {
}
