package org.example.smart_schedulerbackend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.smart_schedulerbackend.mapper.TeacherMapper;
import org.example.smart_schedulerbackend.model.dto.TeacherDTO;
import org.example.smart_schedulerbackend.model.entity.DepartmentInformation;
import org.example.smart_schedulerbackend.model.entity.Teacher;
import org.example.smart_schedulerbackend.model.entity.TeacherInformation;
import org.example.smart_schedulerbackend.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, TeacherInformation> implements TeacherService {

    @Autowired
    private TeacherMapper teacherMapper;

    @Override
    public List<Teacher> getAllTeacherInformation(String department, int page, int size)
    {
        List<Teacher> dataMap = teacherMapper.getAllTeacherInformation(department);
        int start = (page - 1) * size;
        int end = Math.min(start + size, dataMap.size());
        if (start >= dataMap.size()) {
            return List.of();
        }
        return dataMap.subList(start,end);
    }
    @Override
    public List<Teacher> getTeacherInformation(String teacherNumber)
    {
        List<Teacher> dataMap = teacherMapper.getTeacherInformation(teacherNumber);
        return dataMap;
    }

    @Override
    public Map<String,Object> countTeacherInformation(String department)
    {
        Map<String,Object> dataMap = new HashMap<>();
        dataMap.put("number",teacherMapper.countTeacherInformation(department));
        return dataMap;
    };

    @Override
    public Map<String,Object> updatePreference(String teacher_number,String preference)
    {
        Map<String,Object> dataMap = new HashMap<>();
        Map<String,Object> map = new HashMap<>();
        dataMap.put("teacher_number",teacher_number);
        dataMap.put("preference",preference);
        int x = teacherMapper.updatePreference(dataMap);
        map.put("result",x > 0);
        return map;
    };

    @Override
    public List<TeacherDTO> getAllTeachers() {
        return baseMapper.getAllTeachers();
    }

    @Override
    public List<TeacherInformation> searchByKeyword(String keyword) {
        return getBaseMapper().searchByKeyword(keyword);
    }


}
