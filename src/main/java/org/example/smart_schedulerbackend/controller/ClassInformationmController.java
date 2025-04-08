package org.example.smart_schedulerbackend.controller;

import org.example.smart_schedulerbackend.model.entity.ClassInformation;
import org.example.smart_schedulerbackend.service.ClassInformationService;
import org.example.smart_schedulerbackend.service.ClassInformationmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class ClassInformationmController {
    @Autowired
    private ClassInformationmService classInformationService;

    @PostMapping("/updateSchedule")
    public Map<String,Object> updateSchedule(@RequestParam String classSchedulingType, @RequestParam String classname)
    {
        return classInformationService.updateschedule(classSchedulingType,classname);
    }

    @PostMapping("/findclass")
    public List<Map<String, Object>> findclass(@RequestParam String classname)
    {
        return classInformationService.findclass(classname);
    }

    @PostMapping("/getschedulehistory")
    public List<Map<String, Object>> getschedulehistory()
    {
        return classInformationService.getschedulehistory();
    }

    @PostMapping("/searchschedulehistory")
    public List<Map<String,Object>> searchschedulehistory(@RequestParam String classname)
    {
        return classInformationService.searchschedulehistory(classname);
    }
    @PostMapping("/deleteschedulehistory")
    public Map<String,Object> deleteschedule(@RequestParam String classname)
    {
        return classInformationService.deleteschedulehistory(classname);
    }
    @PostMapping("/getallclassinformation")
    public List<ClassInformation> getallclassinformation(@RequestParam String schoolDistricts, @RequestParam String major, @RequestParam int page, @RequestParam int size)
    {
        return classInformationService.getAllClassInformation(schoolDistricts,major,page,size);
    }

    @PostMapping("/countclassinformation")
    public Map<String,Object> countclassinformation(@RequestParam String schoolDistricts, @RequestParam String major)
    {
        return classInformationService.countClassInformation(schoolDistricts,major);
    }

    @GetMapping("/countClass")
    public Map<String,Object> countclass()
    {
        return classInformationService.countClass();
    }
}
