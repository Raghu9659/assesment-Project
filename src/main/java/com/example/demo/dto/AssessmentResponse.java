package com.example.demo.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AssessmentResponse {

    private Long assessmentId;

    private String name;

    private Integer duration;

    private Integer totalMarks;

    private String status;

}
