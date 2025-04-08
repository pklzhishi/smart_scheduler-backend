package org.example.smart_schedulerbackend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.smart_schedulerbackend.mapper.DepartmentInformationMapper;
import org.example.smart_schedulerbackend.model.dto.DepartmentInformationDTO;
import org.example.smart_schedulerbackend.model.entity.DepartmentInformation;
import org.example.smart_schedulerbackend.service.DepartmentInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DepartmentInformationServiceImpl extends ServiceImpl<DepartmentInformationMapper, DepartmentInformation> implements DepartmentInformationService {

    @Autowired
    private DepartmentInformationMapper departmentInformationMapper;

    @Override
    public List<DepartmentInformationDTO> getAllDepartments() {
        return baseMapper.getAllDepartments();
    }

    @Override
    public List<DepartmentInformation> searchByKeyword(String keyword) {
        return getBaseMapper().searchByKeyword(keyword);
    }

    @Override
    public List<Map<String,Object>> getAllDepartmentInformation(int page, int size)
    {
        List<Map<String,Object>> resultList = new ArrayList<>();
        List<DepartmentInformation> dataMap = departmentInformationMapper.getAllDepartmentInformation();
        for(DepartmentInformation classInfo : dataMap)
        {
            Map<String,Object> map = new HashMap<>();
            map.put("departmentNumber",classInfo.getDepartmentNumber());
            map.put("departmentName",classInfo.getDepartmentName());
            map.put("organizationType",classInfo.getOrganizationType());
            map.put("status",classInfo.getStatus());
            resultList.add(map);
        }
        int start = (page - 1) * size;
        int end = Math.min(start + size, dataMap.size());
        if (start >= resultList.size()) {
            return List.of();
        }
        return resultList.subList(start,end);
    };

    @Override
    public Map<String,Object> countDepartmentInformation()
    {
        Map<String,Object> dataMap = new HashMap<>();
        dataMap.put("number",departmentInformationMapper.countDepartmentInformation());
        return dataMap;
    };
}
