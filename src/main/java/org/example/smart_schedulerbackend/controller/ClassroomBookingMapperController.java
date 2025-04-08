package org.example.smart_schedulerbackend.controller;

import org.example.smart_schedulerbackend.service.ClassroomBookingMapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class ClassroomBookingMapperController {
    @Autowired
    private ClassroomBookingMapperService classroomBookingMapperService;

    @PostMapping("/bookingclassroom")
    public Map<String,Object> bookingClassroom(@RequestParam String schoolDistricts,@RequestParam String classroomName,@RequestParam Integer timeWeek,@RequestParam String time)
    {
        return classroomBookingMapperService.bookingClassroom(schoolDistricts,classroomName,timeWeek,time);
    }

    @PostMapping("/cancelclassroom")
    public Map<String,Object> cancelClassroom(@RequestParam String schoolDistricts,@RequestParam String classroomName,@RequestParam Integer timeWeek,@RequestParam String time)
    {
        return classroomBookingMapperService.cancelBooking(schoolDistricts,classroomName,timeWeek,time);
    }
}
