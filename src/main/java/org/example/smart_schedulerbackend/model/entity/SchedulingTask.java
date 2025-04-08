package org.example.smart_schedulerbackend.model.entity;

import lombok.Data;

@Data
public class SchedulingTask {
    private String yearSemester;
    private String courseNumber;
    private String courseName;
    private String teacherNumber;
    private String teacherName;
    private String classCompose;
    private String classId;
    private String courseDescription;
    private String credits;
    private String classroomName;
    private String hourType;
    private String commencementHour;
    private String schedulingHour;
    private String totalHour;
    private String schedulingPriority;
    private String classPeopleNumber;
    private String courseNature;
    private String classSchoolDistrict;
    private String externalType;
    private String classDepartmentName;
    private String classWeeksHours;
    private String rowsNumber;
    private String classroomTypeAssigned;
    private String classroomAssigned;
    private String departmentAssigned;
    private String timeAssigned;
    private String attendanceRate;

    public String getYearSemester() {
        return yearSemester;
    }

    public void setYearSemester(String yearSemester) {
        this.yearSemester = yearSemester;
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

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }

    public String getCredits() {
        return credits;
    }

    public void setCredits(String credits) {
        this.credits = credits;
    }

    public String getClassroomName() {
        return classroomName;
    }

    public void setClassroomName(String classroomName) {
        this.classroomName = classroomName;
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

    public String getCourseNature() {
        return courseNature;
    }

    public void setCourseNature(String courseNature) {
        this.courseNature = courseNature;
    }

    public String getClassSchoolDistrict() {
        return classSchoolDistrict;
    }

    public void setClassSchoolDistrict(String classSchoolDistrict) {
        this.classSchoolDistrict = classSchoolDistrict;
    }

    public String getExternalType() {
        return externalType;
    }

    public void setExternalType(String externalType) {
        this.externalType = externalType;
    }

    public String getClassDepartmentName() {
        return classDepartmentName;
    }

    public void setClassDepartmentName(String classDepartmentName) {
        this.classDepartmentName = classDepartmentName;
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

    public String getDepartmentAssigned() {
        return departmentAssigned;
    }

    public void setDepartmentAssigned(String departmentAssigned) {
        this.departmentAssigned = departmentAssigned;
    }

    public String getTimeAssigned() {
        return timeAssigned;
    }

    public void setTimeAssigned(String timeAssigned) {
        this.timeAssigned = timeAssigned;
    }

    public String getAttendanceRate() {
        return attendanceRate;
    }

    public void setAttendanceRate(String attendanceRate) {
        this.attendanceRate = attendanceRate;
    }
}