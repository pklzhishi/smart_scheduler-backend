package org.example.smart_schedulerbackend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.smart_schedulerbackend.mapper.ClassroomInformationMapper;
import org.example.smart_schedulerbackend.model.dto.ClassroomEquipmentDTO;
import org.example.smart_schedulerbackend.model.dto.ClassroomInformationDTO;
import org.example.smart_schedulerbackend.model.dto.ClassroomUpdateDTO;
import org.example.smart_schedulerbackend.model.entity.ClassroomInformation;
import org.example.smart_schedulerbackend.service.ClassroomInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ClassroomInformationServiceImpl extends ServiceImpl<ClassroomInformationMapper, ClassroomInformation> implements ClassroomInformationService {

    @Autowired
    private ClassroomInformationMapper classroomInformationMapper;


    @Override
    public List<String> getAllSchoolDistricts() {
        return baseMapper.getAllSchoolDistricts();
    }

    @Override
    public List<String> getSchoolBuildingsBySchoolDistricts(String schoolDistricts) {
        return baseMapper.getSchoolBuildingsBySchoolDistricts(schoolDistricts);
    }

    @Override
    public List<ClassroomInformationDTO> getClassroomInformationsBySchoolBuilding(String schoolBuilding) {
        return baseMapper.getClassroomInformationsBySchoolBuilding(schoolBuilding);
    }

    @Override
    public List<ClassroomInformation> searchByKeyword(String keyword) {
        return getBaseMapper().searchByKeyword(keyword);
    }

    @Override
    public void updateClassroomInformation(ClassroomUpdateDTO updateDTO) {
        // 根据 classroomNumber 查询到对应的 ClassroomInformation 对象
        ClassroomInformation existingClassroom = baseMapper.selectByClassroomNumber(updateDTO.getClassroomNumber());
        if (existingClassroom != null) {
            // 更新指定的字段
            existingClassroom.setClassroomName(updateDTO.getClassroomName());
            existingClassroom.setFloor(updateDTO.getFloor());
            existingClassroom.setMaximumCapacity(updateDTO.getMaximumCapacity());
            existingClassroom.setStatus(updateDTO.getStatus());
            existingClassroom.setProjector(updateDTO.getProjector());
            existingClassroom.setLamp(updateDTO.getLamp());
            existingClassroom.setMicrophone(updateDTO.getMicrophone());
            existingClassroom.setAirConditioning(updateDTO.getAirConditioning());

            // 保存更新后的对象
            int result = baseMapper.updateByClassroomNumber(
                    updateDTO.getClassroomNumber(),
                    updateDTO.getClassroomName(),
                    updateDTO.getFloor(),
                    updateDTO.getMaximumCapacity(),
                    updateDTO.getStatus(),
                    updateDTO.getProjector(),
                    updateDTO.getLamp(),
                    updateDTO.getMicrophone(),
                    updateDTO.getAirConditioning()
            );

            if (result > 0) {
                System.out.println("更新成功");
            } else {
                System.out.println("更新失败");
            }
        } else {
            // 处理 classroomNumber 未找到的情况
            throw new RuntimeException("Classroom with number " + updateDTO.getClassroomNumber() + " not found.");
        }
    }

    @Override
    public ClassroomEquipmentDTO getClassroomEquipmentByClassroomName(String classroomName) {
        return baseMapper.getClassroomEquipmentByClassroomName(classroomName);
    }

    @Override
    public int updateProjectorByClassroomName(String classroomName, String projector) {
        return baseMapper.updateProjectorByClassroomName(classroomName, projector);
    }

    @Override
    public int updateLampByClassroomName(String classroomName, String lamp) {
        return baseMapper.updateLampByClassroomName(classroomName, lamp);
    }

    @Override
    public int updateMicrophoneByClassroomName(String classroomName, String microphone) {
        return baseMapper.updateMicrophoneByClassroomName(classroomName, microphone);
    }

    @Override
    public int updateAirConditioningByClassroomName(String classroomName, String airConditioning) {
        return baseMapper.updateAirConditioningByClassroomName(classroomName, airConditioning);
    }


    @Override
    public List<ClassroomInformation> getAllClassroomInformation(String schoolDistricts, String schoolBuilding,int page,int size)
    {
        Map<String,Object> mapx = new HashMap<>();
        mapx.put("schoolDistricts",schoolDistricts);
        mapx.put("schoolBuilding",schoolBuilding);
        List<ClassroomInformation> dataMap = classroomInformationMapper.getAllClassroomInformation(mapx);
        int start = (page - 1) * size;
        int end = Math.min(start + size, dataMap.size());
        if (start >= dataMap.size()) {
            return List.of();
        }
        return dataMap.subList(start,end);
    }

    @Override
    public Map<String,Object> countClassroomInformation(String schoolDistricts, String schoolBuilding)
    {
        Map<String,Object> mapx = new HashMap<>();
        mapx.put("schoolDistricts",schoolDistricts);
        mapx.put("schoolBuilding",schoolBuilding);
        Map<String,Object> dataMap = new HashMap<>();
        dataMap.put("number",classroomInformationMapper.countClassroomInformation(mapx));
        return dataMap;
    }

    @Override
    public List<ClassroomInformation> getEmptyClassroom(String classSchoolDistrict,String schoolBuilding,int timeWeek,String time)
    {
        Map<String,Object> mapx = new HashMap<>();
        mapx.put("classSchoolDistrict",classSchoolDistrict);
        mapx.put("schoolBuilding",schoolBuilding);
        mapx.put("timeWeek",timeWeek);
        mapx.put("time",time);
        return classroomInformationMapper.getEmptyClassroom(mapx);
    }

    @Override
    public Map<String,Long> bookingClassroom(String classroomName)
    {
        Map<String,Long> map = new HashMap<>();
        map.put("result", classroomInformationMapper.bookingClassroom(classroomName));
        return map;
    }
}
