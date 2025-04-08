package org.example.smart_schedulerbackend.controller;

import org.example.smart_schedulerbackend.model.dto.ClassroomEquipmentDTO;
import org.example.smart_schedulerbackend.model.dto.ClassroomInformationDTO;
import org.example.smart_schedulerbackend.model.dto.ClassroomUpdateDTO;
import org.example.smart_schedulerbackend.model.entity.ClassroomInformation;
import org.example.smart_schedulerbackend.service.ClassroomInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class ClassroomInformationController {

    @Autowired
    private ClassroomInformationService classroomInformationService;

    @GetMapping("/school-districts")
    public List<String> getAllSchoolDistricts() {
        return classroomInformationService.getAllSchoolDistricts();
    }

    @GetMapping("/school-buildings")
    public List<String> getSchoolBuildingsBySchoolDistricts(@RequestParam String schoolDistricts) {
        return classroomInformationService.getSchoolBuildingsBySchoolDistricts(schoolDistricts);
    }

    @GetMapping("/classrooms")
    public List<ClassroomInformationDTO> getClassroomInformationsBySchoolBuilding(@RequestParam String schoolBuilding) {
        return classroomInformationService.getClassroomInformationsBySchoolBuilding(schoolBuilding);
    }

    @PostMapping("/classroom-update")
    public void updateClassroomInformation(@RequestBody ClassroomUpdateDTO updateDTO) {
        classroomInformationService.updateClassroomInformation(updateDTO);
    }

    @GetMapping("/get-equipment-statu")
    public ClassroomEquipmentDTO getClassroomEquipmentByClassroomName(
            @RequestParam String classroomName) {
        return classroomInformationService.getClassroomEquipmentByClassroomName(classroomName);
    }

    @PutMapping("/update-projector")
    public int updateProjectorByClassroomName(
            @RequestParam String classroomName,
            @RequestParam String projector) {
        return classroomInformationService.updateProjectorByClassroomName(classroomName, projector);
    }

    @PutMapping("/update-lamp")
    public int updateLampByClassroomName(
            @RequestParam String classroomName,
            @RequestParam String lamp) {
        return classroomInformationService.updateLampByClassroomName(classroomName, lamp);
    }

    @PutMapping("/update-microphone")
    public int updateMicrophoneByClassroomName(
            @RequestParam String classroomName,
            @RequestParam String microphone) {
        return classroomInformationService.updateMicrophoneByClassroomName(classroomName, microphone);
    }

    @PutMapping("/update-air-conditioning")
    public int updateAirConditioningByClassroomName(
            @RequestParam String classroomName,
            @RequestParam String airConditioning) {
        return classroomInformationService.updateAirConditioningByClassroomName(classroomName, airConditioning);
    }

    @PostMapping("/getallclassroominformation")
    public List<ClassroomInformation> getallclassroominformation(@RequestParam String schoolDistricts, @RequestParam String schoolBuilding, @RequestParam int page,
                                                                 @RequestParam int size)
    {
        return classroomInformationService.getAllClassroomInformation(schoolDistricts,schoolBuilding,page,size);
    }

    @PostMapping("/countclassroominformation")
    public Map<String,Object> countclassroominformation(@RequestParam String schoolDistricts, @RequestParam String schoolBuilding)
    {
        return classroomInformationService.countClassroomInformation(schoolDistricts,schoolBuilding);
    }

    @PostMapping("/getemptyclassroom")
    public List<ClassroomInformation> getemptyclassroom(@RequestParam String classSchoolDistrict,@RequestParam String schoolBuilding,@RequestParam int timeWeek,@RequestParam String time)
    {
        return classroomInformationService.getEmptyClassroom(classSchoolDistrict,schoolBuilding,timeWeek,time);
    }

//    @PostMapping("bookingclassroom")
//    public Map<>
}
