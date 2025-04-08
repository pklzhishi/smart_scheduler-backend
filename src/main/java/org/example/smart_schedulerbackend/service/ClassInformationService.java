package org.example.smart_schedulerbackend.service;

import org.example.smart_schedulerbackend.model.dto.ClassInformationDTO;
import org.example.smart_schedulerbackend.model.entity.ClassInformation;

import java.util.List;

public interface ClassInformationService {
    List<ClassInformation> getAllClasses();

    List<ClassInformationDTO> getClassInformationsByMajor(String major);

    List<ClassInformation> searchByKeyword(String keyword);
}
