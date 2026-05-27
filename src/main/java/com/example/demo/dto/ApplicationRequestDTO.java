package com.example.demo.dto;

public class ApplicationRequestDTO {

    private Long studentId;

    private Long jobId;

    public ApplicationRequestDTO() {
    }

    public Long getStudentId() {
        return studentId;
    }

    public Long getJobId() {
        return jobId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }
}