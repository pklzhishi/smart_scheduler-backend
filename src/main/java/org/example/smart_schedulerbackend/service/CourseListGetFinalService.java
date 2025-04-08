package org.example.smart_schedulerbackend.service;

import java.util.List;
import java.util.Map;

public interface CourseListGetFinalService {
    List<Map<String,Object>> getcourselist(String classSchoolDistrict, String classroomname, String timeWeek);
    List<Map<String,Object>> getchangecourselist(String classSchoolDistrict, String classroomname);
    List<Map<String,Object>> getTeacherCourseList(String teacherName,String timeWeek);
    List<Map<String,Object>> getChangeTeacherCourseList(String teacherName);
    Map<String,Long> getClassroomUtilization(String classroomName,Integer timeWeek);
    List<Map<String,Object>> getMonthViewForStudent(String times,String classSchoolDistrict, String className);
    List<Map<String,Object>> getMonthViewForTeacher(String times,String teacherName);
    Map<String,Object> detectConflicts(List<Map<String,Object>> list);
    List<Map<String,Object>> getAttendenceRate(String className);
}
