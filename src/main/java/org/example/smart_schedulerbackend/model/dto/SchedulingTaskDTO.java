package org.example.smart_schedulerbackend.model.dto;

import lombok.Data;

@Data
public class SchedulingTaskDTO {
    private String courseNumber;
    private String courseName;
    private String teacherName;
    private String totalHour;
    private String classWeeksHours;
    private String classroomName;
    private String classSchoolDistrict;
    private String classCompose;
}
