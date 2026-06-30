package com.example.demo.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.AssessmentRequest;
import com.example.demo.dto.AssessmentResponse;
import com.example.demo.entity.Assessment;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.AssessmentRepository;
import com.example.demo.service.AssessmentService;



@Service
public class AssessmentServiceImpl implements AssessmentService {

    @Autowired
    private AssessmentRepository repository;

    @Override
    public AssessmentResponse createAssessment(AssessmentRequest request) {

        Assessment assessment = new Assessment();

        assessment.setName(request.getName());
        assessment.setDuration(request.getDuration());
        assessment.setTotalMarks(request.getTotalMarks());
        assessment.setStatus(request.getStatus());

        Assessment savedAssessment = repository.save(assessment);

        return mapToResponse(savedAssessment);
    }

    @Override
    public List<AssessmentResponse> getAllAssessments() {

        List<Assessment> assessments = repository.findAll();

        List<AssessmentResponse> responseList = new ArrayList<>();

        for (Assessment assessment : assessments) {

            AssessmentResponse response = new AssessmentResponse();

            response.setAssessmentId(assessment.getAssessmentId());
            response.setName(assessment.getName());
            response.setDuration(assessment.getDuration());
            response.setTotalMarks(assessment.getTotalMarks());
            response.setStatus(assessment.getStatus());

            responseList.add(response);
        }

        return responseList;
    }

    @Override
    public AssessmentResponse getAssessmentById(Long assessmentId) {

        Assessment assessment = repository.findById(assessmentId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Assessment not found with id : " + assessmentId));

        return mapToResponse(assessment);
    }

    @Override
    public AssessmentResponse updateAssessment(Long assessmentId, AssessmentRequest request) {

        Assessment assessment = repository.findById(assessmentId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Assessment not found with id : " + assessmentId));

        assessment.setName(request.getName());
        assessment.setDuration(request.getDuration());
        assessment.setTotalMarks(request.getTotalMarks());
        assessment.setStatus(request.getStatus());

        Assessment updatedAssessment = repository.save(assessment);

        return mapToResponse(updatedAssessment);
    }

    @Override
    public void deleteAssessment(Long assessmentId) {

        Assessment assessment = repository.findById(assessmentId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Assessment not found with id : " + assessmentId));

        repository.delete(assessment);
    }

    // Convert Entity to Response DTO
    private AssessmentResponse mapToResponse(Assessment assessment) {

        AssessmentResponse response = new AssessmentResponse();

        response.setAssessmentId(assessment.getAssessmentId());
        response.setName(assessment.getName());
        response.setDuration(assessment.getDuration());
        response.setTotalMarks(assessment.getTotalMarks());
        response.setStatus(assessment.getStatus());

        return response;
    }
}