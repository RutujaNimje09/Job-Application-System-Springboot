package com.example.demo.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"student_id", "job_id"})
        }
)
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate applicationDate;

    private String status;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "job_id")
    private Job job;

    public Application() {
    }

    public Application(Long id, LocalDate applicationDate, String status, Student student, Job job) {
        this.id = id;
        this.applicationDate = applicationDate;
        this.status = status;
        this.student = student;
        this.job = job;
    }

    public Long getId() {
        return id;
    }

    public LocalDate getApplicationDate() {
        return applicationDate;
    }

    public String getStatus() {
        return status;
    }

    public Student getStudent() {
        return student;
    }

    public Job getJob() {
        return job;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setApplicationDate(LocalDate applicationDate) {
        this.applicationDate = applicationDate;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public void setJob(Job job) {
        this.job = job;
    }
}