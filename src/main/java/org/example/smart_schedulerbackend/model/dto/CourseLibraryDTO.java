package org.example.smart_schedulerbackend.model.dto;

import lombok.Data;

@Data
public class CourseLibraryDTO {
    private String courseNumber;
    private String courseName;
    private String courseCategories;
    private String courseProperties;
    private String courseType;
    private String courseNature;
    private String englishName;
    private String department;
    private String enabledStatus;
    private String creditHours;
    private String theoreticalHours;
    private String experimentalHours;
    private String computerBasedHours;
    private String practicalHours;
    private String otherHours;
    private String credits;
    private String weeklyHours;
    private String purelyPractical;
}
