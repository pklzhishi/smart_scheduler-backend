package org.example.smart_schedulerbackend.controller;

import org.example.smart_schedulerbackend.model.dto.ProfessionalDTO;
import org.example.smart_schedulerbackend.service.ProfessionalDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class ProfessionalDataController {

    @Autowired
    private ProfessionalDataService professionalDataService;

    @GetMapping("/affiliations")
    public List<String> getAllAffiliations() {
        return professionalDataService.getAllAffiliations();
    }

    @GetMapping("/professionals")
    public List<ProfessionalDTO> getProfessionalsByAffiliation(@RequestParam String affiliation) {
        return professionalDataService.getProfessionalsByAffiliation(affiliation);
    }

    @PostMapping("/getallprofessionaldata")
    public List<Map<String,Object>> getallprofessionaldata()
    {
        return professionalDataService.getAllProfessionalData();
    }
}
