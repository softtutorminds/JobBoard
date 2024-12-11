package com.pranay.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pranay.model.Job;
import com.pranay.repository.JobRepository;

@Service
public class JobService {
    @Autowired
    private JobRepository jobRepository;
    
    
    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    public void addJob(Job job) {
        jobRepository.save(job);
    }

    public void deleteJob(Long jobId) {
        jobRepository.deleteById(jobId);
    }

}
