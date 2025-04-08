package org.example.smart_schedulerbackend.model.entity;

import lombok.Data;

@Data
public class ClassroomInformation {
    private String classroomNumber;
    private String classroomName;
    private String schoolDistricts;
    private String schoolBuilding;
    private String floor;
    private String classroomLabels;
    private String classroomType;
    private String capacity;
    private String maximumCapacity;
    private String status;
    private String classroomDescription;
    private String managementDepartment;
    private String weeklyHours;
    private String classroomSize;
    private String tableType;
    private String projector;
    private String lamp;
    private String microphone;
    private String airConditioning;
    private String isBooking;
}