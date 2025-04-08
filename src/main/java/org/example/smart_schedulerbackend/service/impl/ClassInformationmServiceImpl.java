package org.example.smart_schedulerbackend.service.impl;

import org.example.smart_schedulerbackend.mapper.ClassInformationmMapper;
import org.example.smart_schedulerbackend.model.entity.ClassInformation;
import org.example.smart_schedulerbackend.service.ClassInformationmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ClassInformationmServiceImpl implements ClassInformationmService {
    @Autowired
    private ClassInformationmMapper classInformationMapper;

    @Override
    public Map<String,Object> updateschedule(String classSchedulingType, String classname)
    {
        Map<String,Object> dataMap = new HashMap<>();
        Map<String,Object> map = new HashMap<>();
        dataMap.put("classSchedulingType",classSchedulingType);
        dataMap.put("classname",classname);
        dataMap.put("classSchedulingTime", LocalDateTime.now());
        dataMap.put("isDelete",0);
        int x = classInformationMapper.updateScheduleType(dataMap);
        map.put("result",x>0);
        return map;
    }
    @Override
    public List<Map<String, Object>> findclass(String classname)
    {
        List<Map<String,Object>> resultList = new ArrayList<>();
        List<ClassInformation> dataMap = classInformationMapper.findClass(classname);
        for(ClassInformation classInfo : dataMap)
        {
            Map<String,Object> map = new HashMap<>();
            map.put("classNumber",classInfo.getClassNumber());
            map.put("classname",classInfo.getClassName());
            map.put("classSchedulingType",classInfo.getClassSchedulingType());
            resultList.add(map);
        }
        return resultList;
    }
    @Override
    public List<Map<String, Object>> getschedulehistory()
    {
        List<Map<String, Object>> resultList = new ArrayList<>();
        List<ClassInformation> dataMap = classInformationMapper.getScheduleHistory();
        for(ClassInformation classInfo : dataMap)
        {
            Map<String,Object> map = new HashMap<>();
            map.put("classSchedulingType",classInfo.getClassSchedulingType());
            map.put("classname",classInfo.getClassName());
            map.put("classSchedulingTime",classInfo.getClassSchedulingTime());
            resultList.add(map);
        }
        return resultList;
    }
    @Override
    public List<Map<String,Object>> searchschedulehistory(String classname)
    {
        List<Map<String,Object>> resultList = new ArrayList<>();
        List<ClassInformation> dataMap = classInformationMapper.searchScheduleHistory(classname);
        for(ClassInformation classInfo : dataMap)
        {
            Map<String,Object> map = new HashMap<>();
            map.put("classSchedulingType",classInfo.getClassSchedulingType());
            map.put("classname",classInfo.getClassName());
            map.put("classSchedulingTime",classInfo.getClassSchedulingTime());
            resultList.add(map);
        }
        return resultList;
    }
    @Override
    public Map<String,Object> deleteschedulehistory(String classname)
    {
        int x = classInformationMapper.deleteScheduleHistory(classname);
        Map<String,Object> dataMap = new HashMap<>();
        dataMap.put("result",x > 0);
        return dataMap;
    }
    @Override
    public List<ClassInformation> getAllClassInformation(String schoolDistricts, String major,int page,int size)
    {
        Map<String,Object> mapx = new HashMap<>();
        mapx.put("schoolDistricts",schoolDistricts);
        mapx.put("major",major);
        List<ClassInformation> dataMap = classInformationMapper.getAllClassInformation(mapx);
        int start = (page - 1) * size;
        int end = Math.min(start + size, dataMap.size());
        if (start >= dataMap.size()) {
            return List.of();
        }
        return dataMap.subList(start,end);
    }

    @Override
    public Map<String,Object> countClassInformation(String schoolDistricts, String major)
    {
        Map<String,Object> mapx = new HashMap<>();
        mapx.put("schoolDistricts",schoolDistricts);
        mapx.put("major",major);
        Map<String,Object> dataMap = new HashMap<>();
        dataMap.put("number",classInformationMapper.countClassInformation(mapx));
        return dataMap;
    }

    @Override
    public Map<String,Object> countClass()
    {
        Map<String,Object> map = new HashMap<>();
        Long x1 = classInformationMapper.countClass();
        Long x2 = classInformationMapper.countSchedulingByAi();
        Long x3 = classInformationMapper.countSchedulingByHand();
        Long x4 = classInformationMapper.countSchedulingExport();
        Long x5 = x1 - x2;
        map.put("AllClassNumber",x1);
        map.put("SchedulingByAiNumber",x2);
        map.put("SchedulingByHandNumber",x3);
        map.put("SchedulingExportNumber",x4);
        map.put("NotFinish",x5);
        return map;
    }
}
