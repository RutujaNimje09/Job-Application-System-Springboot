package com.example.demo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.ApplicationRequestDTO;
import com.example.demo.entity.Application;
import com.example.demo.service.ApplicationService;

@RestController
@RequestMapping("/applications")
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;

    @PostMapping("/apply")
    public Application applyJob(@RequestBody ApplicationRequestDTO dto) {

        return applicationService.applyJob(dto);
    }

    @GetMapping
    public List<Application> getApplications() {

        return applicationService.getAllApplications();
    }
}