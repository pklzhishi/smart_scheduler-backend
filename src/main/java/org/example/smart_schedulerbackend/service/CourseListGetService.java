package org.example.smart_schedulerbackend.service;
import org.example.smart_schedulerbackend.model.dto.SchedulingTaskDTO;
import org.example.smart_schedulerbackend.model.dto.SchedulingTaskDTO2;
import org.example.smart_schedulerbackend.model.dto.SchedulingTaskDTO3;
import org.example.smart_schedulerbackend.model.entity.SchedulingTask;

import java.util.List;
import java.util.Map;

public interface CourseListGetService {
    void addSchedulingTask(SchedulingTaskDTO task);
    String getAttendanceRate(String classSchoolDistrict, String classCompose, String courseNumber);
    int updateAttendanceRateByFields(String classSchoolDistrict, String classCompose, String courseNumber, String attendanceRate);
    List<SchedulingTaskDTO2> getSchedulingTaskDTO2ByClassroomName(String classroomName);
//    SchedulingTaskDTO getSchedulingTaskByClassCompose(String classCompose);

    List<SchedulingTaskDTO3> getSchedulingTaskByClassCompose(String classCompose);
}
