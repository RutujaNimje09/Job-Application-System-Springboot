package com.example.demo.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ApplicationRequestDTO;
import com.example.demo.entity.Application;
import com.example.demo.entity.Job;
import com.example.demo.entity.Student;
import com.example.demo.repository.ApplicationRepository;
import com.example.demo.repository.JobRepository;
import com.example.demo.repository.StudentRepository;

@Service
public class ApplicationService {

    @Autowired
    private ApplicationRepository applicationRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private JobRepository jobRepository;

    public Application applyJob(ApplicationRequestDTO dto) {

        if(applicationRepository.existsByStudentIdAndJobId(
                dto.getStudentId(),
                dto.getJobId()
        )) {
            throw new RuntimeException("Student already applied for this job");
        }

        Student student = studentRepository.findById(dto.getStudentId())
                .orElseThrow(() -> new RuntimeException("Student not found"));

        Job job = jobRepository.findById(dto.getJobId())
                .orElseThrow(() -> new RuntimeException("Job not found"));

        Application application = new Application();

        application.setApplicationDate(LocalDate.now());
        application.setStatus("APPLIED");
        application.setStudent(student);
        application.setJob(job);

        return applicationRepository.save(application);
    }

    public List<Application> getAllApplications() {
        return applicationRepository.findAll();
    }
}