package com.example.demo.validation;



import org.springframework.stereotype.Component;


import com.example.demo.dto.AssessmentResponse;

@Component
public class AssessmentValidator {

    public void validateAssessment(AssessmentResponse request) {

        if (request.getName() == null || request.getName().trim().isEmpty()) {
            throw new IllegalArgumentException("Assessment name is required");
        }

        if (request.getDuration() == null || request.getDuration() <= 0) {
            throw new IllegalArgumentException("Duration must be greater than 0");
        }

        if (request.getTotalMarks() == null || request.getTotalMarks() <= 0) {
            throw new IllegalArgumentException("Total Marks must be greater than 0");
        }

        if (request.getStatus() == null || request.getStatus().trim().isEmpty()) {
            throw new IllegalArgumentException("Status is required");
        }
    }
}