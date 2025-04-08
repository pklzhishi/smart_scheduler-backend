package org.example.smart_schedulerbackend.service;

import org.example.smart_schedulerbackend.model.entity.ClassInformation;

import java.util.List;
import java.util.Map;

public interface ClassInformationmService {
    Map<String,Object> updateschedule(String classSchedulingType, String classname);
    List<Map<String, Object>> findclass(String classname);
    List<Map<String, Object>> getschedulehistory();
    List<Map<String,Object>> searchschedulehistory(String classname);
    Map<String,Object> deleteschedulehistory(String classname);
    List<ClassInformation> getAllClassInformation(String schoolDistricts, String major, int page, int size);
    Map<String,Object> countClassInformation(String schoolDistricts, String major);
    Map<String,Object> countClass();
}
