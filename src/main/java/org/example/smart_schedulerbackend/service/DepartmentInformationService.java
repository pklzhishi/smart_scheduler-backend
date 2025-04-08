package org.example.smart_schedulerbackend.service;

import org.example.smart_schedulerbackend.model.dto.DepartmentInformationDTO;
import org.example.smart_schedulerbackend.model.entity.DepartmentInformation;

import java.util.List;
import java.util.Map;

public interface DepartmentInformationService {
    List<DepartmentInformationDTO> getAllDepartments();

    List<DepartmentInformation> searchByKeyword(String keyword);

    List<Map<String,Object>> getAllDepartmentInformation(int page, int size);
    Map<String,Object> countDepartmentInformation();

}
