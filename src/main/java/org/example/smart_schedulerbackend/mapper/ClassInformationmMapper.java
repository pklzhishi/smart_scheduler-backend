package org.example.smart_schedulerbackend.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.smart_schedulerbackend.model.entity.ClassInformation;

import java.util.List;
import java.util.Map;

@Mapper
public interface ClassInformationmMapper {
    int updateScheduleType(Map<String,Object> param);
    List<ClassInformation> findClass(String classname);
    List<ClassInformation> getScheduleHistory();
    List<ClassInformation> searchScheduleHistory(String classname);
    int deleteScheduleHistory(String classname);
    List<ClassInformation> getAllClassInformation(Map<String,Object> param);
    long countClassInformation(Map<String,Object> param);
    Long countClass();
    Long countSchedulingByHand();
    Long countSchedulingExport();
    Long countSchedulingByAi();
}
