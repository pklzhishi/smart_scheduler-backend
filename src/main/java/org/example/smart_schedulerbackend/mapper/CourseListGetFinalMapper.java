package org.example.smart_schedulerbackend.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.smart_schedulerbackend.model.entity.SchedulingTaskFinal;

import java.util.List;
import java.util.Map;

@Mapper
public interface CourseListGetFinalMapper {
    List<SchedulingTaskFinal> getCourseList(Map<String,String> param);
    List<SchedulingTaskFinal> getChangeCourseList(Map<String,String> param);
    List<SchedulingTaskFinal> getTeacherCourseList(Map<String,String> param);
    List<SchedulingTaskFinal> getChangeTeacherCourseList(Map<String,String> param);
    Long getClassroomUtilization(Map<String,Object> param);
    List<Map<String,Object>> detectConflictsByClass(Map<String,Object> param);
    List<Map<String,Object>> detectConflictsByTeacher(Map<String,Object> param);
    Long deleteClassSchedule(String classCompose);
    Long insertClassSchedule(Map<String,Object> param);
    List<Map<String,Object>> getAttendenceRate(String className);
}
