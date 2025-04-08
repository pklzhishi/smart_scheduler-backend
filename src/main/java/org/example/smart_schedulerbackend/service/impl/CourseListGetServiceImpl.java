package org.example.smart_schedulerbackend.service.impl;

import org.example.smart_schedulerbackend.mapper.CourseListGetMapper;
import org.example.smart_schedulerbackend.model.dto.SchedulingTaskDTO;
import org.example.smart_schedulerbackend.model.dto.SchedulingTaskDTO2;
import org.example.smart_schedulerbackend.model.dto.SchedulingTaskDTO3;
import org.example.smart_schedulerbackend.model.entity.SchedulingTask;
import org.example.smart_schedulerbackend.model.entity.SchedulingTaskFinal;
import org.example.smart_schedulerbackend.service.CourseListGetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CourseListGetServiceImpl implements CourseListGetService {
    @Autowired
    private CourseListGetMapper courseListGetMapper;

    @Override
    public void addSchedulingTask(SchedulingTaskDTO taskDTO) {
        SchedulingTask task = convertToSchedulingTask(taskDTO);
        // 调用 MyBatis-Plus 提供的通用插入方法
        int result = courseListGetMapper.insert(task);
        if (result > 0) {
            System.out.println("插入成功！");
        } else {
            System.out.println("插入失败！");
        }
    }

    @Override
    public String getAttendanceRate(String classSchoolDistrict, String classCompose,String courseNumber) {
        return courseListGetMapper.getAttendanceRateByClassSchoolDistrictAndClassCompose(classSchoolDistrict, classCompose ,courseNumber);
    }

    @Override
    public int updateAttendanceRateByFields(String classSchoolDistrict, String classCompose, String courseNumber, String attendanceRate) {
        return courseListGetMapper.updateAttendanceRateByFields(classSchoolDistrict, classCompose, courseNumber, attendanceRate);
    }

    @Override
    public List<SchedulingTaskDTO2> getSchedulingTaskDTO2ByClassroomName(String classroomName) {
        return courseListGetMapper.getSchedulingTaskDTO2ByClassroomName(classroomName);
    }

    private SchedulingTask convertToSchedulingTask(SchedulingTaskDTO dto) {
        SchedulingTask task = new SchedulingTask();
        task.setCourseNumber(dto.getCourseNumber());
        task.setCourseName(dto.getCourseName());
        task.setTeacherName(dto.getTeacherName());
        task.setTotalHour(dto.getTotalHour());
        task.setClassWeeksHours(dto.getClassWeeksHours());
        task.setClassroomName(dto.getClassroomName());
        task.setClassSchoolDistrict(dto.getClassSchoolDistrict());
        task.setClassCompose(dto.getClassCompose());
        // 根据需要设置其他字段
        return task;
    }

    @Override
    public List<SchedulingTaskDTO3> getSchedulingTaskByClassCompose(String classCompose) {
        return courseListGetMapper.selectSchedulingTasksByClassCompose(classCompose);
    }

}
