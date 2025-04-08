package org.example.smart_schedulerbackend.model.dto;

import lombok.Data;

@Data
public class ClassroomUpdateDTO {
    private String classroomNumber;
    private String classroomName;
    private String floor;
    private String maximumCapacity;
    private String status;
    private String projector;
    private String lamp;
    private String microphone;
    private String airConditioning;
}
