package org.example.smart_schedulerbackend.model.entity;

public class ClassroomBooking {
    private Integer id;
    private String classroomName;
    private String schoolDistricts;
    private Integer timeWeek;
    private String time;
    private String isBooking;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClassroomName() {
        return classroomName;
    }

    public void setClassroomName(String classroomName) {
        this.classroomName = classroomName;
    }

    public String getSchoolDistricts() {
        return schoolDistricts;
    }

    public void setSchoolDistricts(String schoolDistricts) {
        this.schoolDistricts = schoolDistricts;
    }

    public Integer getTimeWeek() {
        return timeWeek;
    }

    public void setTimeWeek(Integer timeWeek) {
        this.timeWeek = timeWeek;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getIsBooking() {
        return isBooking;
    }

    public void setIsBooking(String isBooking) {
        this.isBooking = isBooking;
    }
}
