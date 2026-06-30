package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.AssessmentRequest;
import com.example.demo.dto.AssessmentResponse;
import com.example.demo.service.AssessmentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/assessments")
@Validated
public class AssessmentController {

    @Autowired
    private AssessmentService service;

    // Create Assessment
    @PostMapping
    public AssessmentResponse createAssessment(
            @Valid @RequestBody AssessmentRequest request) {

        return service.createAssessment(request);
    }

    // Get All Assessments
    @GetMapping
    public List<AssessmentResponse> getAllAssessments() {

        return service.getAllAssessments();
    }

    // Get Assessment By Id
    @GetMapping("/{id}")
    public AssessmentResponse getAssessmentById(
            @PathVariable Long id) {

        return service.getAssessmentById(id);
    }

    // Update Assessment
    @PutMapping("/{id}")
    public AssessmentResponse updateAssessment(
            @PathVariable Long id,
            @Valid @RequestBody AssessmentRequest request) {

        return service.updateAssessment(id, request);
    }

    // Delete Assessment
    @DeleteMapping("/{id}")
    public String deleteAssessment(@PathVariable Long id) {

        service.deleteAssessment(id);

        return "Assessment Deleted Successfully";
    }

}