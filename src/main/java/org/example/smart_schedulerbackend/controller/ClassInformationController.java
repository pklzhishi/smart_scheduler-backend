package org.example.smart_schedulerbackend.controller;

import org.example.smart_schedulerbackend.model.dto.ClassInformationDTO;
import org.example.smart_schedulerbackend.model.entity.ClassInformation;
import org.example.smart_schedulerbackend.service.ClassInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClassInformationController {

    @Autowired
    private ClassInformationService classInformationService;

    @GetMapping("/all-classes")
    public List<ClassInformation> getAllClasses() {
        return classInformationService.getAllClasses();
    }

    @GetMapping("/classes")
    public List<ClassInformationDTO> getClassInformationsByMajor(@RequestParam String major) {
        return classInformationService.getClassInformationsByMajor(major);
    }
}
