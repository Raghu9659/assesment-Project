package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.AssessmentRequest;
import com.example.demo.dto.AssessmentResponse;



public interface AssessmentService {

    // Create Assessment
    AssessmentResponse createAssessment(AssessmentRequest request);

    // Get All Assessments
    List<AssessmentResponse> getAllAssessments();

    // Get Assessment By ID
    AssessmentResponse getAssessmentById(Long assessmentId);

    // Update Assessment
    AssessmentResponse updateAssessment(Long assessmentId, AssessmentRequest request);

    // Delete Assessment
    void deleteAssessment(Long assessmentId);

}