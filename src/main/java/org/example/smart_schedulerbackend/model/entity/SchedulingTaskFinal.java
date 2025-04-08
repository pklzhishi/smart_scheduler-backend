package org.example.smart_schedulerbackend.model.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SchedulingTaskFinal {
    private String yearSemester;
    private String time;
    private String courseNumber;
    private String courseName;
    private String teacherNumber;
    private String teacherName;
    private String classCompose;
    private String credits;
    private String hourType;
    private String commencementHour;
    private String schedulingHour;
    private String totalHour;
    private String schedulingPriority;
    private String classPeopleNumber;
    private String classSchoolDistrict;
    private String classWeeksHours;
    private String rowsNumber;
    private String classroomTypeAssigned;
    private String classroomAssigned;
    private String classroomName;
    private String attendanceRate;

    public String getYearSemester() {
        return yearSemester;
    }

    public void setYearSemester(String yearSemester) {
        this.yearSemester = yearSemester;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getCourseNumber() {
        return courseNumber;
    }

    public void setCourseNumber(String courseNumber) {
        this.courseNumber = courseNumber;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getTeacherNumber() {
        return teacherNumber;
    }

    public void setTeacherNumber(String teacherNumber) {
        this.teacherNumber = teacherNumber;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getClassCompose() {
        return classCompose;
    }

    public void setClassCompose(String classCompose) {
        this.classCompose = classCompose;
    }

    public String getCredits() {
        return credits;
    }

    public void setCredits(String credits) {
        this.credits = credits;
    }

    public String getHourType() {
        return hourType;
    }

    public void setHourType(String hourType) {
        this.hourType = hourType;
    }

    public String getCommencementHour() {
        return commencementHour;
    }

    public void setCommencementHour(String commencementHour) {
        this.commencementHour = commencementHour;
    }

    public String getSchedulingHour() {
        return schedulingHour;
    }

    public void setSchedulingHour(String schedulingHour) {
        this.schedulingHour = schedulingHour;
    }

    public String getTotalHour() {
        return totalHour;
    }

    public void setTotalHour(String totalHour) {
        this.totalHour = totalHour;
    }

    public String getSchedulingPriority() {
        return schedulingPriority;
    }

    public void setSchedulingPriority(String schedulingPriority) {
        this.schedulingPriority = schedulingPriority;
    }

    public String getClassPeopleNumber() {
        return classPeopleNumber;
    }

    public void setClassPeopleNumber(String classPeopleNumber) {
        this.classPeopleNumber = classPeopleNumber;
    }

    public String getClassSchoolDistrict() {
        return classSchoolDistrict;
    }

    public void setClassSchoolDistrict(String classSchoolDistrict) {
        this.classSchoolDistrict = classSchoolDistrict;
    }

    public String getClassWeeksHours() {
        return classWeeksHours;
    }

    public void setClassWeeksHours(String classWeeksHours) {
        this.classWeeksHours = classWeeksHours;
    }

    public String getRowsNumber() {
        return rowsNumber;
    }

    public void setRowsNumber(String rowsNumber) {
        this.rowsNumber = rowsNumber;
    }

    public String getClassroomTypeAssigned() {
        return classroomTypeAssigned;
    }

    public void setClassroomTypeAssigned(String classroomTypeAssigned) {
        this.classroomTypeAssigned = classroomTypeAssigned;
    }

    public String getClassroomAssigned() {
        return classroomAssigned;
    }

    public void setClassroomAssigned(String classroomAssigned) {
        this.classroomAssigned = classroomAssigned;
    }

    public String getClassroom() {
        return classroomName;
    }

    public void setClassroom(String classroomName) {
        this.classroomName = classroomName;
    }

    public String getClassroomName() {
        return classroomName;
    }

    public void setClassroomName(String classroomName) {
        this.classroomName = classroomName;
    }

    public String getAttendenceRate() {
        return attendanceRate;
    }

    public void setAttendenceRate(String attendenceRate) {
        this.attendanceRate = attendenceRate;
    }
}