package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Job;
import com.example.demo.repository.JobRepository;

@RestController
@RequestMapping("/jobs")
public class JobController {

    @Autowired
    private JobRepository jobRepository;

    @PostMapping
    public Job createJob(@RequestBody Job job) {
        return jobRepository.save(job);
    }

    @GetMapping
    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }
}