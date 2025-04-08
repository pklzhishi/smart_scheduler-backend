package org.example.smart_schedulerbackend.controller;

import org.example.smart_schedulerbackend.model.dto.SchedulingTaskDTO;
import org.example.smart_schedulerbackend.model.dto.SchedulingTaskDTO2;
import org.example.smart_schedulerbackend.model.dto.SchedulingTaskDTO3;
import org.example.smart_schedulerbackend.model.entity.SchedulingTask;
import org.example.smart_schedulerbackend.service.CourseListGetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class CourseListGetController {
    @Autowired
    private CourseListGetService courseListGetService;

    @PostMapping("/addSchedulingTask")
    public String addSchedulingTask(@RequestBody SchedulingTaskDTO task) {
        System.out.println("接收到前端的请求：" + task);
        courseListGetService.addSchedulingTask(task);
        return "插入成功！";
    }

    @GetMapping("/attendanceRate")
    public String getAttendanceRate(
            @RequestParam String classSchoolDistrict,
            @RequestParam String classCompose,
            @RequestParam String courseNumber) {
        return courseListGetService.getAttendanceRate(classSchoolDistrict, classCompose, courseNumber);
    }

    @PutMapping("/update-attendance-rate")
    public int updateAttendanceRateByFields(
            @RequestParam String classSchoolDistrict,
            @RequestParam String classCompose,
            @RequestParam String courseNumber,
            @RequestParam String attendanceRate) {
        return courseListGetService.updateAttendanceRateByFields(classSchoolDistrict, classCompose, courseNumber, attendanceRate);
    }

    @GetMapping("/getSchedulingTask-of-classroom")
    public List<SchedulingTaskDTO2> getSchedulingTaskDTO2ByClassroomName(
            @RequestParam String classroomName) {
        return courseListGetService.getSchedulingTaskDTO2ByClassroomName(classroomName);
    }

    @GetMapping("/attendanceRate-analysis")
    public List<SchedulingTaskDTO3> getSchedulingTaskByClassCompose(@RequestParam String classCompose) {
        return courseListGetService.getSchedulingTaskByClassCompose(classCompose);
    }
}
