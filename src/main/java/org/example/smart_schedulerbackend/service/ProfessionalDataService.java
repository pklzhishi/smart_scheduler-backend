package org.example.smart_schedulerbackend.service;

import org.example.smart_schedulerbackend.model.dto.ProfessionalDTO;

import java.util.List;
import java.util.Map;

public interface ProfessionalDataService {
    List<String> getAllAffiliations();
    List<ProfessionalDTO> getProfessionalsByAffiliation(String affiliation);
    List<Map<String,Object>> getAllProfessionalData();

}
