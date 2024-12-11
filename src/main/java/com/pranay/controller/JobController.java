package com.pranay.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.pranay.model.Job;
import com.pranay.service.JobService;

@Controller
public class JobController {
    @Autowired
    private JobService jobService;

    @GetMapping("/job-list")
    public String viewJobs(Model model) {
        model.addAttribute("jobs", jobService.getAllJobs());
        return "job-list";
    }

    @GetMapping("/jobform")
    public String jobForm() {
        return "job-form";
    }

    @PostMapping("/addjob")
    public String addJob(Job job) {
        jobService.addJob(job);
        return "redirect:/job-list";
    }
    
    
    @GetMapping("/deletejob")
    public String deleteJobForm(Model model) {
        model.addAttribute("jobs", jobService.getAllJobs());
        return "deletejob"; 
    }
    
    @PostMapping("/deletejob")
    public String deleteJob(Long jobId) {
        jobService.deleteJob(jobId);
        return "redirect:/job-list";
    }



}
