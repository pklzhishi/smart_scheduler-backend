package org.example.smart_schedulerbackend.service;

import org.example.smart_schedulerbackend.model.dto.ClassroomEquipmentDTO;
import org.example.smart_schedulerbackend.model.dto.ClassroomInformationDTO;
import org.example.smart_schedulerbackend.model.dto.ClassroomUpdateDTO;
import org.example.smart_schedulerbackend.model.entity.ClassInformation;
import org.example.smart_schedulerbackend.model.entity.ClassroomInformation;

import java.util.List;
import java.util.Map;

public interface ClassroomInformationService {
    List<String> getAllSchoolDistricts();
    List<String> getSchoolBuildingsBySchoolDistricts(String schoolDistricts);
    List<ClassroomInformationDTO> getClassroomInformationsBySchoolBuilding(String schoolBuilding);
    List<ClassroomInformation> searchByKeyword(String keyword);
    void updateClassroomInformation(ClassroomUpdateDTO updateDTO);
    ClassroomEquipmentDTO getClassroomEquipmentByClassroomName(String classroomName);

    int updateProjectorByClassroomName(String classroomName, String projector);

    int updateLampByClassroomName(String classroomName, String lamp);

    int updateMicrophoneByClassroomName(String classroomName, String microphone);

    int updateAirConditioningByClassroomName(String classroomName, String airConditioning);

    List<ClassroomInformation> getAllClassroomInformation(String schoolDistricts, String schoolBuilding,int page,int size);
    Map<String,Object> countClassroomInformation(String schoolDistricts, String schoolBuilding);
    List<ClassroomInformation> getEmptyClassroom(String classSchoolDistrict,String schoolBuilding,int timeWeek,String time);
    Map<String,Long> bookingClassroom(String classroomName);
}
