package org.example.smart_schedulerbackend.controller;

import org.example.smart_schedulerbackend.service.CourseListGetFinalService;
import org.example.smart_schedulerbackend.service.CourseListGetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
@RestController
public class CourseListGetFinalController {
    @Autowired
    private CourseListGetFinalService courseListGetFinalService;

    @PostMapping("/courselistget")
    public List<Map<String,Object>> courselistget(@RequestParam String classSchoolDistrict, @RequestParam String classname, @RequestParam String timeWeek)
    {
        return courseListGetFinalService.getcourselist(classSchoolDistrict,classname,timeWeek);
    }

    @PostMapping("/getchangecourselist")
    public List<Map<String,Object>> getchangecourselist(@RequestParam String classSchoolDistrict, @RequestParam String classname)
    {
        return courseListGetFinalService.getchangecourselist(classSchoolDistrict,classname);
    }

    @PostMapping("/getteachercourselist")
    public List<Map<String,Object>> getTeacherCourseList(@RequestParam String teacherName,@RequestParam String timeWeek)
    {
        return courseListGetFinalService.getTeacherCourseList(teacherName,timeWeek);
    }

    @PostMapping("/getchangeteachercourselist")
    public List<Map<String,Object>> getChangeTeacherCourseList(@RequestParam String teacherName)
    {
        return courseListGetFinalService.getChangeTeacherCourseList(teacherName);
    }

    @PostMapping("/getclassroomutilization")
    public Map<String,Long> getClassroomUtilization(@RequestParam String classroomName,@RequestParam Integer timeWeek)
    {
        return courseListGetFinalService.getClassroomUtilization(classroomName,timeWeek);
    }

    @PostMapping("/getMonthViewForStudent")
    public List<Map<String,Object>> getMonthViewForStudent(@RequestParam String classSchoolDistrict, @RequestParam String classname, @RequestParam String time)
    {
        return courseListGetFinalService.getMonthViewForStudent(time,classSchoolDistrict,classname);
    }

    @PostMapping("/getMonthViewForTeacher")
    public List<Map<String,Object>> getMonthViewForTeacher(@RequestParam String teacherName, @RequestParam String time)
    {
        return courseListGetFinalService.getMonthViewForTeacher(time,teacherName);
    }

    @PostMapping("/detectConflicts")
    public Map<String,Object> detectConflicts(@RequestBody List<Map<String,Object>> list)
    {
        return courseListGetFinalService.detectConflicts(list);
    }

    @PostMapping("/getAttendenceRate")
    public List<Map<String,Object>> getAttendenceRate(@RequestParam String className)
    {
        return courseListGetFinalService.getAttendenceRate(className);
    }
}
