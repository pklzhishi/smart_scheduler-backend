package org.example.smart_schedulerbackend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.smart_schedulerbackend.mapper.ClassInformationMapper;
import org.example.smart_schedulerbackend.model.dto.ClassInformationDTO;
import org.example.smart_schedulerbackend.model.entity.ClassInformation;
import org.example.smart_schedulerbackend.service.ClassInformationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassInformationServiceImpl extends ServiceImpl<ClassInformationMapper, ClassInformation> implements ClassInformationService {

    @Override
    public List<ClassInformation> getAllClasses() {
        return baseMapper.selectList(null);
    }

    @Override
    public List<ClassInformationDTO> getClassInformationsByMajor(String major) {
        return baseMapper.getClassInformationsByMajor(major);
    }

    @Override
    public List<ClassInformation> searchByKeyword(String keyword) {
        return getBaseMapper().searchByKeyword(keyword);
    }
}
