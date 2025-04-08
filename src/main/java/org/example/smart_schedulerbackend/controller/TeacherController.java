package org.example.smart_schedulerbackend.controller;

import org.example.smart_schedulerbackend.model.dto.TeacherDTO;
import org.example.smart_schedulerbackend.model.entity.Teacher;
import org.example.smart_schedulerbackend.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @GetMapping("/teachers")
    public List<TeacherDTO> getAllTeachers() {
        return teacherService.getAllTeachers();
    }

    @PostMapping("/getallteacherinformation")
    public List<Teacher> getallteacherinformation(@RequestParam String department, @RequestParam int page, @RequestParam int size)
    {
        return teacherService.getAllTeacherInformation(department,page,size);
    }
    @PostMapping("/getteacherinformation")
    public List<Teacher> getteacherinformation(@RequestParam String teacherNumber)
    {
        return teacherService.getTeacherInformation(teacherNumber);
    }

    @PostMapping("/countteacherinformation")
    public Map<String,Object> countteacherinformation(@RequestParam String department)
    {
        return teacherService.countTeacherInformation(department);
    }

    @PostMapping("/updatepreference")
    public Map<String,Object> updatepreference(@RequestParam String teacher_number,@RequestParam String preference)
    {
        return teacherService.updatePreference(teacher_number,preference);
    }
}
