package org.example.smart_schedulerbackend.model.entity;

public class Remark {
    private Integer id;
    private String yearSemester;
    private String courseNumber;
    private String className;
    private String weeks;
    private String days;
    private String times;
    private String remarkInformation;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getWeeks() {
        return weeks;
    }

    public void setWeeks(String weeks) {
        this.weeks = weeks;
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public String getTimes() {
        return times;
    }

    public void setTimes(String times) {
        this.times = times;
    }
    public String getRemarkInformation() {
        return remarkInformation;
    }

    public void setRemarkInformation(String remarkInformation) {
        this.remarkInformation = remarkInformation;
    }
}
